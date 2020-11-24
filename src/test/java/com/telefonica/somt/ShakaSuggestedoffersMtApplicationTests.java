package com.telefonica.somt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hazelcast.util.StringUtil;
import com.telefonica.somt.business.others.PublicId;
import com.telefonica.somt.business.recurringPrice.ClientMaintainTenure;
import com.telefonica.somt.business.variables.CustomerProduct.CustomerProductVariable;
import com.telefonica.somt.business.variables.ElegibleOfferMt.ElegibleOffersMtVariable;
import com.telefonica.somt.commons.Constant;
import com.telefonica.somt.commons.Util;
import com.telefonica.somt.dto.SuggestedOffersMtRequestDto;
import com.telefonica.somt.dto.productInventory.Characteristic;
import com.telefonica.somt.dto.productInventory.ProductInventoryResponseDto;
import com.telefonica.somt.dto.productInventory.ProductPrice;
import com.telefonica.somt.dto.productInventory.ProductRelationship;
import com.telefonica.somt.entity.rtdm.CompoWithPropandvalidVal;
import com.telefonica.somt.entity.rtdm.FactRecargaKpi;
import com.telefonica.somt.entity.rtdm.MigrationOffer;
import com.telefonica.somt.entity.rtdm.Offeringquad;
import com.telefonica.somt.entity.rtdm.Offeringquaddetail;
import com.telefonica.somt.entity.rtdm.RelationsMaster;
import com.telefonica.somt.generated.model.ComposingProductType.ProductTypeEnum;
import com.telefonica.somt.generated.model.ProductSpecCharacteristicType.ValueTypeEnum;
import com.telefonica.somt.generated.model.ResponseType;
import com.telefonica.somt.generated.model.StringWrapper;
import com.telefonica.somt.pojo.clientTenure.ClientTenure;
import com.telefonica.somt.pojo.clientTenure.ClientTenureResponse;
import com.telefonica.somt.pojo.clientTenure.ProductCharacteristic;
import com.telefonica.somt.pojo.clientTenure.PublicIdResponse;
import com.telefonica.somt.pojo.request.Broadband;
import com.telefonica.somt.pojo.request.Plan;
import com.telefonica.somt.pojo.request.Product;
import com.telefonica.somt.pojo.variables.elegibleOffersMt.ElegibleOffersMt;
import com.telefonica.somt.pojo.variables.productInventory.CustomerProduct;
import com.telefonica.somt.pojo.variables.productInventory.FijaProduct;
import com.telefonica.somt.pojo.variables.productInventory.MobileProduct;
import com.telefonica.somt.proxy.elegibleOffersMt.ElegibleOffersMtConnection;
import com.telefonica.somt.proxy.productInventory.ProductInventoryConnection;
import com.telefonica.somt.repository.daas.PrincipalcomponentFAldmRepository;
import com.telefonica.somt.repository.rtdm.AltaOfferRepository;
import com.telefonica.somt.repository.rtdm.CompoWithPropandvalidValRepository;
import com.telefonica.somt.repository.rtdm.FactRecargaKpiRepository;
import com.telefonica.somt.repository.rtdm.InterPlnSpeedandtechRateRepository;
import com.telefonica.somt.repository.rtdm.MigrationOfferRepository;
import com.telefonica.somt.repository.rtdm.OfferingquadRepository;
import com.telefonica.somt.repository.rtdm.OfferingquaddetailRepository;
import com.telefonica.somt.repository.rtdm.RelationsMasterRepository;

@SpringBootTest
class ShakaSuggestedoffersMtApplicationTests {

    @Autowired
    private ProductInventoryConnection	       parqueUnificadoConnection;
    @Autowired
    private ElegibleOffersMtConnection	       elegibleOffersMtConnection;
    @Autowired
    private OfferingquaddetailRepository       offeringquaddetailRepository;
    @Autowired
    private PrincipalcomponentFAldmRepository  principalcomponentFAldmRepository;
    @Autowired
    private MigrationOfferRepository	       migrationOfferRepository;
    @Autowired
    private OfferingquadRepository	       offeringquadRepository;
    @Autowired
    private RelationsMasterRepository	       relationsMasterRepository;
    @Autowired
    private CompoWithPropandvalidValRepository compoWithPropandvalidValRepository;
    @Autowired
    private InterPlnSpeedandtechRateRepository interPlnSpeedandtechRateRepository;


    @Autowired
    private ClientMaintainTenure     clientMaintainTenure;
    @Autowired
    private PublicId		     publicId;
    @Autowired
    private CustomerProductVariable  customerProductVariable;
    @Autowired
    private ElegibleOffersMtVariable elegibleOffersMtVariable;
    @Autowired
    private FactRecargaKpiRepository factRecargaKpiRepository;
    @Autowired
    private AltaOfferRepository	     altaOfferRepository;

    private SuggestedOffersMtRequestDto request;

    @Test
    void test1() {

    }

    @Test
    void contextLoads() {
	System.out.println("hola");

	FactRecargaKpi factRecargaKpi = factRecargaKpiRepository.findByTelefono("902433031");
	System.out.println(factRecargaKpi);
	Float arpa = (float) 220;
	String altaOffer = altaOfferRepository.findByArpa("Trio", "Y", "soloFija", arpa);
	System.out.println(altaOffer);
	
	BigDecimal gapArpa = new BigDecimal(1);
	BigDecimal gapSpeed = new BigDecimal(1);
	String altaOfferGap = altaOfferRepository.findByGapArpaAndSpeed("DUO TV", gapArpa, gapSpeed, "soloFija porta");
	System.out.println("altaOfferGap :" +altaOfferGap);
	
	String altaOfferGapDuo = altaOfferRepository.findByGapArpaDuoBa("DUO BA", gapArpa, gapSpeed, "soloFija porta");
	System.out.println("altaOfferGapDuo :" +altaOfferGapDuo);

	String parrillActual = "1";
	MigrationOffer migrationOffer = migrationOfferRepository
		.findByCurrentPlanAndAffiliatedMobileLineAndDestinationParrillaIgnoreCase("459", 2, Constant.CURRENT_PARRILLA);

	if (migrationOffer.getCurrentParrilla().contains(parrillActual)) {
	    System.out.println(migrationOffer);
	}

	MigrationOffer priorizedOffer = migrationOfferRepository.findByPrioritizedOfferAndDestinationParrillaIgnoreCase("275",
		Constant.CURRENT_PARRILLA);

	System.out.println("priorizedOffer :" + priorizedOffer);

	List<String> offeringid = new ArrayList<>();
	offeringid.add("1");
	offeringid.add("2");
	offeringid.add("3");

	List<Offeringquad> offeringquad = offeringquadRepository.findByOfferingquadIdIn(offeringid);
	System.out.println("offeringquad :" + offeringquad);

	String principalcomponentFAldm = principalcomponentFAldmRepository.findProductkeyByIdProductOffer("53654065");
	System.out.println(principalcomponentFAldm);

	List<Offeringquaddetail> offeringquaddetailList = offeringquaddetailRepository.findByOfferingcid("35317365");

	String network = interPlnSpeedandtechRateRepository.findByquey(request.getNetworkTechnology(), request.getAction());

	System.out.println(network);

    }

    @BeforeEach
    void Before() {
	request = new SuggestedOffersMtRequestDto();
	Broadband broadband = new Broadband();
	Product product = new Product();
	Plan plan = new Plan();

	// //MT
	// request.setNationalId("45234899");
	// product.setPublicId("920952088,WRSL;217088,BB");

	// TRIOS Y DUOS
	request.setNationalId("43485083");
	product.setPublicId("14948734,BB");

	request.setNationalIdType("DNI");
	request.setCategoryId("3195941");
	request.setChannelId("CEC");
	product.setType("MT");
	request.setProduct(product);
	request.setCreditScore(9990);
	request.setCreditLimit(BigDecimal.valueOf(999));
	request.setRegion("15");
	request.setStateOrProvince("1");
	request.setCustomerSegment("R");
	request.setIsPortability(false);
	request.setDealerId("91001");
	request.setIsRetention(true);
	request.setProductOfferingCatalogId("3");
	request.setAction("PR");
	request.setCommercialAreaId("1");
	request.setSiteId("91001001");
	plan.setId("4269648:34715111");
	request.setPlan(plan);
	request.setCurrentOffering("34423415");
	request.setNetworkTechnology("HFC");
	request.setServiceabilityMaxSpeed("300");
	request.setSubscriberGroupValue("POS1");
	request.setInstallationAddressDepartment("15");
	broadband.setConnection("HFC");
	request.setBroadband(broadband);

    }

    @Test
    private CustomerProduct customerProducyVariableTest(SuggestedOffersMtRequestDto request) {

	List<ProductInventoryResponseDto> customerTenancy = parqueUnificadoConnection.callRestService(request.getNationalId(),
		request.getNationalIdType());

	CustomerProduct customerProduct = new CustomerProduct();
	List<MobileProduct> customerProductMobileList = new ArrayList<>();
	FijaProduct fijaProduct = new FijaProduct();

	Integer numMobileLine = 0;

	for (ProductInventoryResponseDto product : customerTenancy) {

	    if (product.getProductType().equalsIgnoreCase("mobile")) {
		if (product.getPublicId().equals("14948734") || product.getPublicId().equals("8091464967000")
			|| product.getPublicId().equals("920952088")) {

		    Boolean amdocs = false;

		    MobileProduct mobileProduct = new MobileProduct();

		    for (Characteristic characteristic : product.getCharacteristics()) {

			if ("originSystem".equalsIgnoreCase(characteristic.getName())) {
			    System.out.println(characteristic.getName());
			    mobileProduct.setMobilePlantType("0");
			    if (characteristic.getValue().equals("ALDM")) {
				mobileProduct.setMobilePlantType("1");
				amdocs = true;
			    }
			}

			if ("indicatorMT".equalsIgnoreCase(characteristic.getName())) {
			    mobileProduct.setMobileMtClient(characteristic.getValue().toString());
			    if ("Y".equalsIgnoreCase(characteristic.getValue().toString())) {
				numMobileLine += 1;
			    }
			}
		    }

		    if (Boolean.TRUE.equals(amdocs)) {

			for (Characteristic characteristic : product.getCharacteristics()) {

			    if ("PortingInd".equalsIgnoreCase(characteristic.getName())) {
				mobileProduct.setPortabilityMobileIndicator(characteristic.getValue().toString());
			    }

			}

			mobileProduct.setMobileLineType("2");

			if ("postpaid".equalsIgnoreCase(product.getBillingAccounts().get(0).getBillingMethod())) {
			    mobileProduct.setMobileLineType("1");
			}

			mobileProduct.setMobileOfferCodeOrigin(product.getProductOffering().getId());

		    }
		    mobileProduct.setRentMobile(product.getProductPrices().get(0).getPrice().getAmount());

		    if (Boolean.TRUE.equals(amdocs)) {
			customerProductMobileList.add(mobileProduct);
		    }
		}

	    } else {

		if (product.getProductRelationship().get(0).getProduct().getPublicId().equalsIgnoreCase("217088")) {

		    Boolean amdocs = true;

		    for (Characteristic characteristic : product.getCharacteristics()) {

			if ("originSystem".equalsIgnoreCase(characteristic.getName())) {
			    System.out.println(characteristic.getName());
			    fijaProduct.setFijaPlantType("0");
			    if (characteristic.getValue().equals("ATIS") || characteristic.getValue().equals("CMS")) {
				amdocs = true;
				fijaProduct.setFijaPlantType("1");
			    }
			}

			if ("bundleLOBS".equalsIgnoreCase(characteristic.getName())) {

			    String originPackage = characteristic.getValue().toString();
			    fijaProduct.setOriginPackage(originPackage);

			    // TODO CREAR METODO PARA ESTA LOGICA

			    if ("Voice+Internet+TV".equalsIgnoreCase(originPackage)) {

				fijaProduct.setOriginOfferType("TRIO");

			    } else if ("Voice+Internet".equalsIgnoreCase(originPackage)) {
				fijaProduct.setOriginOfferType("DUO INTERNET");
			    } else if ("Voice+TV".equalsIgnoreCase(originPackage)) {
				fijaProduct.setOriginOfferType("DUO TV");
			    } else if ("Internet+TV".equalsIgnoreCase(originPackage)) {
				fijaProduct.setOriginOfferType("DUO INT + TV CATV");
			    } else if ("Voice".equalsIgnoreCase(originPackage)) {
				fijaProduct.setOriginOfferType("MONO LINEA");
			    } else if ("TV".equalsIgnoreCase(originPackage)) {
				fijaProduct.setOriginOfferType("MONO TV");
			    } else if ("Internet".equalsIgnoreCase(originPackage)) {
				fijaProduct.setOriginOfferType("MONO INTERNET");
			    }

			}

			if ("indicatorMT".equalsIgnoreCase(characteristic.getName())) {
			    fijaProduct.setFijaMtClient(characteristic.getValue().toString());
			}
		    }

		    if (Boolean.TRUE.equals(amdocs)) {

			for (ProductRelationship productRelationship : product.getProductRelationship()) {

			    String productType = productRelationship.getProduct().getProductType();
			    System.out.println(productType);
			    List<Characteristic> charasteristicList = productRelationship.getProduct().getCharacteristics();

			    for (Characteristic characteristic : charasteristicList) {
				if ("landline".equalsIgnoreCase(productType) && "PortingInd".equalsIgnoreCase(characteristic.getName())) {
				    fijaProduct.setPortabilityFijaIndicator(characteristic.getValue().toString());
				}

			    }

			    if ("broadband".equalsIgnoreCase(productType)) {

				for (ProductRelationship productRelationshipChild : productRelationship.getProduct()
					.getProductRelationship()) {

				    List<Characteristic> charasteristicChildList = productRelationshipChild.getProduct()
					    .getCharacteristics();

				    if ("Internet_Plan".equalsIgnoreCase(productRelationshipChild.getProduct().getName())) {

					charasteristicChildList.forEach(charasteristic -> {

					    if ("Commercial_Download_Speed".equalsIgnoreCase(charasteristic.getName())) {
						fijaProduct.setOriginSpeed(charasteristic.getValue().toString());
					    }

					});

				    }

				    if ("Access".equalsIgnoreCase(productRelationshipChild.getProduct().getName())) {

					charasteristicChildList.forEach(charasteristic -> {

					    if ("Network_Technology".equalsIgnoreCase(charasteristic.getName())) {
						fijaProduct.setInternetTechnology(charasteristic.getValue().toString());
					    }

					});

				    }

				    if ("Ultra_WiFi".equalsIgnoreCase(productRelationshipChild.getProduct().getName())) {
					fijaProduct.setIdRepeaterOrigin(productRelationshipChild.getProduct().getProductSpec().getId());

				    }

				}

			    }

			    if ("cableTv".equalsIgnoreCase(productType)) {
				for (ProductRelationship productRelationshipChild : productRelationship.getProduct()
					.getProductRelationship()) {

				    List<Characteristic> charasteristicChildList = productRelationshipChild.getProduct()
					    .getCharacteristics();

				    if ("TV_Plan".equalsIgnoreCase(productRelationshipChild.getProduct().getName())) {

					charasteristicChildList.forEach(charasteristic -> {
					    if ("Fulfillment_Code".equalsIgnoreCase(charasteristic.getName())) {
						fijaProduct.setTvType("N");
						if (charasteristic.getValue().toString().contains("estelar")) {
						    fijaProduct.setTvType("Y");
						}

					    }
					});

				    }

				    if ("TV_Service_Technology".equalsIgnoreCase(productRelationshipChild.getProduct().getName())) {

					charasteristicChildList.forEach(charasteristic -> {
					    if ("TV_Service_Technology".equalsIgnoreCase(charasteristic.getName())) {
						fijaProduct.setTvTechnology(charasteristic.getValue().toString());
					    }
					});

				    }

				    if ("sva".equalsIgnoreCase(productRelationshipChild.getProduct().getProductType())) {
					productRelationshipChild.getProduct().getProductRelationship().forEach(pr -> {
					    if ("sva".equalsIgnoreCase(pr.getProduct().getProductType())) {
						if ("Channels_Pack".equalsIgnoreCase(pr.getProduct().getName())) {
						    fijaProduct.setCodParentTvBlockOrigin(pr.getProduct().getProductSpec().getId());

						    List<String> nameTvBlockOrigin = new ArrayList<>();
						    List<String> codeTvBlockOrigin = new ArrayList<>();

						    pr.getProduct().getCharacteristics().forEach(characteristic -> {

							if ("Pack_Name".equalsIgnoreCase(characteristic.getName())) {
							    nameTvBlockOrigin.add(characteristic.getValue().toString());
							}

							if ("Item_Identifier".equalsIgnoreCase(characteristic.getName())) {
							    codeTvBlockOrigin.add(characteristic.getValue().toString());
							}

						    });

						    fijaProduct.setNameTvBlockOrigin(nameTvBlockOrigin);
						    fijaProduct.setCodeTvBlockOrigin(codeTvBlockOrigin);
						}
					    }

					});

				    }

				    if ("STBS".equalsIgnoreCase(productRelationshipChild.getProduct().getName())) {
					List<String> productTypeDecoOriginList = new ArrayList<>();
					List<String> typeDecoOriginlist = new ArrayList<>();
					Integer numDecoOrigin = 0;

					for (ProductRelationship pr : productRelationshipChild.getProduct().getProductRelationship()) {
					    if ("STB".equalsIgnoreCase(pr.getProduct().getName())) {
						productTypeDecoOriginList.add(pr.getProduct().getProductType());
					    }

					    List<Characteristic> charasteristicPrList = pr.getProduct().getCharacteristics();
					    for (Characteristic charasteristic : charasteristicPrList) {
						if ("STB_Type".equalsIgnoreCase(charasteristic.getName())) {
						    typeDecoOriginlist.add(charasteristic.getValue().toString());
						    numDecoOrigin += 1;
						}
					    }

					}
					fijaProduct.setProductTypeDecoOrigin(productTypeDecoOriginList);
					fijaProduct.setTypeDecoOrigin(typeDecoOriginlist);
					fijaProduct.setNumDecoOrigin(numDecoOrigin);
				    }

				}

				if ("TV_Main".equalsIgnoreCase(productRelationship.getProduct().getName())) {
				    productRelationship.getProduct().getProductRelationship().forEach(productRelationshipChild -> {
					if ("TV_Additional_Services".equalsIgnoreCase(productRelationshipChild.getProduct().getName())) {
					    productRelationshipChild.getProduct().getProductRelationship().forEach(pr -> {
						if ("Channels_Pack".equalsIgnoreCase(pr.getProduct().getName())) {
						    List<ProductPrice> productPricePrList = pr.getProduct().getProductPrices();

						    productPricePrList.forEach(productPrice -> {
							fijaProduct.setRentTvBlockOrigin(productPrice.getPrice().getAmount());

						    });

						}
					    });
					}
				    });

				}

			    }

			    if ("Shared_Equipment_Main".equalsIgnoreCase(productRelationship.getProduct().getName())) {

				for (ProductRelationship productRelationshipChild : productRelationship.getProduct()
					.getProductRelationship()) {
				    if ("device".equalsIgnoreCase(productRelationshipChild.getProduct().getProductType())) {

					productRelationshipChild.getProduct().getProductRelationship().forEach(pr -> {

					    if ("device".equalsIgnoreCase(pr.getProduct().getProductType())) {
						List<Characteristic> charasteristicPrList = pr.getProduct().getCharacteristics();
						charasteristicPrList.forEach(charasteristic -> {
						    if ("Equipment_Type".equalsIgnoreCase(charasteristic.getName())) {
							fijaProduct.setTypeModemOrigin(charasteristic.getValue().toString());
						    }
						    if ("Equipment_Sub_Type".equalsIgnoreCase(charasteristic.getName())) {
							fijaProduct.setSubTypeModemOrigin(charasteristic.getValue().toString());

						    }
						});
					    }

					});

				    }

				}
			    }

			}

			product.getProductPrices().forEach(productPrice -> {

			    if ("total price".equalsIgnoreCase(productPrice.getName())) {
				fijaProduct.setRentPackageOrigin(productPrice.getPrice().getAmount());
			    }
			});
			fijaProduct.setOfferCodeOrigin(product.getProductOffering().getId());

			customerProduct.setFijaProduct(fijaProduct);

		    }

		}
	    }
	}

	customerProduct.setMobileProduct(customerProductMobileList);
	customerProduct.setNumMobileLine(numMobileLine);

	return customerProduct;
    }

    @Test
    private List<ElegibleOffersMt> elegibleOffersMtVariableTet(SuggestedOffersMtRequestDto request) {

	ResponseType responseType = elegibleOffersMtConnection.callRestService(request);
	String CodCatalogo_TecnologiaTV = "3196511";
	String CodProducto_TV = "3197521";

	List<ElegibleOffersMt> elegibleOffersMtList = new ArrayList<>();

	responseType.getOfferings().forEach(offering -> {

	    ElegibleOffersMt elegibleOffersMt = new ElegibleOffersMt();

	    elegibleOffersMt.setCodOffer(offering.getId());

	    String description = offering.getDescription();
	    String[] str = description.split(" ");
	    elegibleOffersMt.setSpeed(str[str.length - 2]);

	    offering.getProductSpecification().forEach(productSpecification -> {
		ProductTypeEnum productType = productSpecification.getProductType();

		if (ProductTypeEnum.MOBILE.equals(productType)) {
		    elegibleOffersMt.setCodMobile(productSpecification.getId());
		} else {
		    elegibleOffersMt.setCodFija(productSpecification.getId());
		}

		productSpecification.getRefinedProduct().getSubProducts().forEach(subProduct -> {
		    ProductTypeEnum subproductType = subProduct.getProductType();

		    if (ProductTypeEnum.CABLETV.equals(subproductType)) {

			List<String> svaTypeTvDecoList = new ArrayList<>();
			List<String> codSvaTvBlockList = new ArrayList<>();

			subProduct.getRefinedProduct().getSubProducts().forEach(sp -> {

			    ProductTypeEnum spType = sp.getProductType();
			    if (ProductTypeEnum.SVA.equals(spType)) {
				elegibleOffersMt.setIdSvaTvBlock(sp.getId());
				sp.getRefinedProduct().getProductCharacteristics().forEach(productCharacteristic -> {

				    codSvaTvBlockList.add(productCharacteristic.getId());

				});

			    }
			    if (ProductTypeEnum.DEVICE.equals(spType)) {

				sp.getRefinedProduct().getProductCharacteristics().forEach(productCharacteristic -> {
				    StringWrapper stringWrapper = (StringWrapper) productCharacteristic;

				    stringWrapper.getProductSpecCharacteristicValue().forEach(productCharacteristicValue -> {

					svaTypeTvDecoList.add(productCharacteristicValue.getValue());
				    });
				});
				// TODO EN EL RESPONSE NO LLEGA ESTE VALOR, POR LO QUE NO SE HA PROBADO BIEN

				if (sp.getName().contains("MODEM")) {

				    sp.getRefinedProduct().getProductCharacteristics().forEach(productCharacteristic -> {

					StringWrapper stringWrapper = (StringWrapper) productCharacteristic;

					stringWrapper.getProductSpecCharacteristicValue().forEach(productCharacteristicValue -> {

					    elegibleOffersMt.setSvaTypeEq(productCharacteristicValue.getValue());

					});
				    });
				}
			    }
			});

			elegibleOffersMt.setCodSvaTvBlock(codSvaTvBlockList);
			elegibleOffersMt.setSvaTypeTvDeco(svaTypeTvDecoList);
			elegibleOffersMt.setNumSvatvDeco(svaTypeTvDecoList.size());

		    }

		    if (ProductTypeEnum.BROADBAND.equals(subproductType)) {

			subProduct.getRefinedProduct().getSubProducts().forEach(sp -> {

			    if (ProductTypeEnum.DEVICE.equals(sp.getProductType())) {
				elegibleOffersMt.setIdSvaBb(sp.getId());

			    }
			});

		    }

		});

	    });

	    offering.getProductOfferingPrice().forEach(productOfferingPrice -> {
		elegibleOffersMt.setTotalPrice(productOfferingPrice.getPriceWithTax().getAmount());
		System.out.println(elegibleOffersMt);
	    });

	    List<Offeringquaddetail> offeringquaddetailList = offeringquaddetailRepository.findByOfferingcid(elegibleOffersMt.getCodFija());

	    System.out.println(elegibleOffersMt.getCodFija());

	    RelationsMaster relationsMaster = new RelationsMaster();

	    if (!StringUtil.isNullOrEmpty(offeringquaddetailList.get(0).getOfferingcid())) {

		relationsMaster = relationsMasterRepository.findByChildId(CodCatalogo_TecnologiaTV);

		String tvTechnology = null;

		if (!StringUtil.isNullOrEmpty(relationsMaster.getChildId())) {
		    List<CompoWithPropandvalidVal> compoWithPropandvalidVal = compoWithPropandvalidValRepository
			    .findByCompomentCid(relationsMaster.getChildId());

		    tvTechnology = compoWithPropandvalidVal.get(0).getDefaultValue();

		} else {

		    relationsMaster = relationsMasterRepository.findByRootCidAndChildId(CodProducto_TV, CodCatalogo_TecnologiaTV);

		    List<CompoWithPropandvalidVal> compoWithPropandvalidVal = compoWithPropandvalidValRepository
			    .findByCompomentCid(relationsMaster.getChildId());

		    tvTechnology = compoWithPropandvalidVal.get(0).getDefaultValue();

		}

		String internetTechnology = interPlnSpeedandtechRateRepository.findByquey(request.getNetworkTechnology(),
			request.getAction());

		elegibleOffersMt.setTvTechnology(tvTechnology);
		elegibleOffersMt.setInternetTechnology(internetTechnology);

	    }

	    elegibleOffersMtList.add(elegibleOffersMt);

	});
	return elegibleOffersMtList;
    }

    @Test
    void getAndValidateCustomerOfferTest() {

	PublicIdResponse publicIdResponse = publicId.getPublicId(request.getProduct().getPublicId());

	System.out.println(publicIdResponse);

	// CustomerProduct customerProduct = customerProducyVariableTest(request);
	// List<ElegibleOffersMt> elegibleOffersMtList =
	// elegibleOffersMtVariable(request);
	ResponseType elegibleOfferMtService = elegibleOffersMtConnection.callRestService(request);
	List<ElegibleOffersMt> elegibleOffersMtList = elegibleOffersMtVariable.getElegibleOffersMtVariable(request, elegibleOfferMtService);
	
	

	System.out.println(elegibleOffersMtList);

	if (Objects.nonNull(elegibleOffersMtList) || elegibleOffersMtList.isEmpty()) {

	    CustomerProduct customerProduct = customerProductVariable.getCustomerProductVariable(request, publicIdResponse);
	    System.out.println(customerProduct);

	    List<MobileProduct> mobileProductList = customerProduct.getMobileProduct();
	    FijaProduct fijaProduct = customerProduct.getFijaProduct();
	    
	    if (mobileProductList.size() == 1 && fijaProduct == null ) {
		if ("N".equalsIgnoreCase(mobileProductList.get(0).getMobileMtClient())) {
		    mobileProductList.get(0).setOriginOfferType("SOLO MOVIL");
		}
	    }

	    if ("Y".equalsIgnoreCase(fijaProduct.getFijaMtClient()) || "Y".equalsIgnoreCase(mobileProductList.get(0).getMobileMtClient())) {

		System.out.println("ES MT");

		// 3. Evaluar oferta actual respecto a las reglas de migración:

		List<MigrationOffer> priorizedOfferList = new ArrayList<>();
		List<String> offeringIdList = new ArrayList<>();

		// TODO 3.e
		if (request.getNetworkTechnology().contains("")) {

		    MigrationOffer migrationOffer = migrationOfferRepository.findByPrioritizedOfferAndDestinationParrillaIgnoreCase("275",
			    Constant.CURRENT_PARRILLA);

		    priorizedOfferList.add(migrationOffer);

		} else {
		    // TODO 3.a hasta d

		    if ("Y".equalsIgnoreCase(fijaProduct.getFijaMtClient())) {
			List<Offeringquaddetail> offeringquaddetailList;

			offeringquaddetailList = offeringquaddetailRepository.findByOfferingcid(fijaProduct.getOfferCodeOrigin());
			String offeringId = null;

			if (Boolean.FALSE.equals(offeringquaddetailList.isEmpty())) {

			    offeringId = offeringquaddetailList.stream()
				    .filter(x -> fijaProduct.getOriginSpeed().equalsIgnoreCase(x.getDownloadspeed()))
				    .map(Offeringquaddetail::getOfferingid).collect(Collectors.joining());
			} else {
			    String productKey = principalcomponentFAldmRepository
				    .findProductkeyByIdProductOffer(fijaProduct.getOfferCodeOrigin());

			    offeringquaddetailList = offeringquaddetailRepository.findByOfferingcid(productKey);

			    offeringId = offeringquaddetailList.stream()
				    .filter(x -> fijaProduct.getOriginSpeed().equalsIgnoreCase(x.getDownloadspeed()))
				    .map(Offeringquaddetail::getOfferingid).collect(Collectors.joining());
			}

			offeringIdList.add(offeringId);
		    }

		    if ("Y".equalsIgnoreCase(mobileProductList.get(0).getMobileMtClient())) {

			mobileProductList.forEach(mobileProduct -> {

			    List<Offeringquaddetail> offeringquaddetailList;

			    offeringquaddetailList = offeringquaddetailRepository
				    .findByOfferingcid(mobileProduct.getMobileOfferCodeOrigin());

			    if (Boolean.FALSE.equals(offeringquaddetailList.isEmpty())) {

				offeringquaddetailList.forEach(offeringquad -> {
				    offeringIdList.add(offeringquad.getOfferingid());
				});

			    } else {
				String productKey = principalcomponentFAldmRepository
					.findProductkeyByIdProductOffer(mobileProduct.getMobileOfferCodeOrigin());

				offeringquaddetailList = offeringquaddetailRepository.findByOfferingcid(productKey);

				offeringquaddetailList.forEach(offeringquad -> {
				    offeringIdList.add(offeringquad.getOfferingid());
				});
			    }
			});
		    }

		    List<Offeringquad> offeringquadList = offeringquadRepository.findByOfferingquadIdIn(offeringIdList);

		    for (Offeringquad offeringquad : offeringquadList) {

			MigrationOffer migrationOffer = migrationOfferRepository
				.findByCurrentPlanAndAffiliatedMobileLineAndDestinationParrillaIgnoreCase(offeringquad.getAmountwithtax(),
					customerProduct.getNumMobileLine(), Constant.CURRENT_PARRILLA);
			if (migrationOffer.getCurrentParrilla().contains(offeringquad.getTipoParrilla())) {
			    priorizedOfferList.add(migrationOffer);

			}

		    }

		}
		// 4. Validar si el cliente aplica Migración
		if (!(priorizedOfferList == null && priorizedOfferList.isEmpty())) {

		    for (MigrationOffer migrationOffer : priorizedOfferList) {

			// 5. Evaluar oferta actual respecto a las reglas

			Offeringquad offeringquad = offeringquadRepository.findByTipoParrillaAndAmountwithtax(
				migrationOffer.getCurrentParrilla(), migrationOffer.getPrioritizedOffer());

			if (!StringUtil.isNullOrEmpty(offeringquad.getOfferingquadId())) {
			    for (ElegibleOffersMt elegibleOffersMt : elegibleOffersMtList) {

				// 6. Buscar oferta priorizada destino en listado de ofertas elegibles MT
				if (elegibleOffersMt.getCodOffer().equalsIgnoreCase(offeringquad.getOfferingquadId())) {

				    // 7. Obtener otros costos adicionales

				    ClientTenureResponse recurringPriceResponse = clientMaintainTenure.getClientTenure(fijaProduct,
					    elegibleOffersMt);

				    // TODO llenar response con recurringPrice y demas datos

				} else {
				    // 404
				}

			    }
			} else {
			    // 404
			}

		    }

		} else {
		    // retorna 404
		}

	    } else {
		System.out.println("NO ES MT");

		// TODO PREGUNTAR SI ACA VENDRAN DOS LINEAS MOBILES O SOLO UNA

		if ("TRIO".equalsIgnoreCase(fijaProduct.getOriginOfferType())
			|| "DUO BA+TV".equalsIgnoreCase(fijaProduct.getOriginOfferType())) {
		    System.out.println("entro trio duo");

		    mobileProductList.forEach(mobileProduct -> {

			String cluster = clusterTest(publicIdResponse, fijaProduct, mobileProduct);

			Float promPrepago = (float) 0;

			FactRecargaKpi factRecargaKpi = factRecargaKpiRepository.findByTelefono(mobileProduct.getMobileNumber());
			promPrepago = factRecargaKpi.getPrommontorecargas();

			Float arpa = fijaProduct.getRentPackageOrigin() + fijaProduct.getRentTvBlockOrigin() + mobileProduct.getRentMobile()
				+ promPrepago;

			String prioritizedOffer = altaOfferRepository.findByArpa(fijaProduct.getOriginOfferType(), fijaProduct.getTvType(),
				cluster, arpa);

			if (!StringUtil.isNullOrEmpty(prioritizedOffer)) {

			    Offeringquad offeringquad = offeringquadRepository.findByTipoParrillaAndAmountwithtax("3", prioritizedOffer);

			    if (!StringUtil.isNullOrEmpty(offeringquad.getOfferingquadId())) {

				Offeringquad offeringquadId = offeringquadRepository.findByOfferingquadId(offeringquad.getOfferingquadId());

				if (!StringUtil.isNullOrEmpty(offeringquadId.getOfferingquadId())) {

				    for (ElegibleOffersMt elegibleOffersMt : elegibleOffersMtList) {

					if (elegibleOffersMt.getCodOffer().equalsIgnoreCase(offeringquadId.getOfferingquadId())) {

					    ClientTenureResponse recurringPriceResponse = clientMaintainTenure.getClientTenure(fijaProduct,
						    elegibleOffersMt);

					    Float recurringPrice = (float) 0;

					    if ("Y".equalsIgnoreCase(fijaProduct.getTvType())) {
						// TODO FALTA UNA VARIABLE
//						Float tvEstelar = (float) 20;
//						recurringPrice = recurringPriceResponse.getRepeaterSvaAdicPrice()
//							+ recurringPriceResponse.getRepeaterSvaAdicPrice() + tvEstelar;
					    }

					    // TODO POBLAR RESPONSE
					}
				    }

				} else {
				    // retorna 404
				}

			    } else {
				// retorna 404
			    }
			} else {
			    // retorna 404
			}
		    });

		} else {

		    // TODO DUOS MONOS Y SOLO MOVIL

		    if ("DUO BA".equalsIgnoreCase(fijaProduct.getOriginOfferType())
			    || "DUO TV".equalsIgnoreCase(fijaProduct.getOriginOfferType())
			    || "MONO BA".equalsIgnoreCase(fijaProduct.getOriginOfferType())
			    || "MONO TV".equalsIgnoreCase(fijaProduct.getOriginOfferType())
			    || "MONO LINEA".equalsIgnoreCase(fijaProduct.getOriginOfferType())
			    || "SOLO MOVIL".equalsIgnoreCase(mobileProductList.get(0).getOriginOfferType())) {

			elegibleOffersMtList.forEach(elegibleOffersMt -> {

			    String cluster = null;
			    Float promPrepago = (float) 0;
			    Float arpa = (float) 0;
			    BigDecimal originSpeed = new BigDecimal(fijaProduct.getOriginSpeed());
			    BigDecimal mtSpeed = new BigDecimal(elegibleOffersMt.getSpeed());

			    if (Boolean.FALSE.equals(mobileProductList.isEmpty())) {

				for (MobileProduct mobileProduct : mobileProductList) {

				    cluster = clusterTest(publicIdResponse, fijaProduct, mobileProduct);

				    FactRecargaKpi factRecargaKpi = factRecargaKpiRepository
					    .findByTelefono(mobileProduct.getMobileNumber());
				    promPrepago = factRecargaKpi.getPrommontorecargas();

				    arpa = fijaProduct.getRentPackageOrigin() + fijaProduct.getRentTvBlockOrigin()
					    + mobileProduct.getRentMobile() + promPrepago;
				}
			    } else {

				cluster = clusterTest(publicIdResponse, fijaProduct, null);
				arpa = fijaProduct.getRentPackageOrigin() + fijaProduct.getRentTvBlockOrigin();
			    }

			    BigDecimal gapArpa = elegibleOffersMt.getTotalPrice().subtract(Util.addIgv(arpa));
			    BigDecimal gapSpeed = mtSpeed.subtract(originSpeed).divide(originSpeed);
			    
			    String altaOfferId;
			    
			    if ("DUO BA".equalsIgnoreCase(fijaProduct.getOriginOfferType())) {
				 altaOfferId = altaOfferRepository.findByGapArpaDuoBa(fijaProduct.getOriginOfferType(), gapArpa, gapSpeed, cluster);
			    }else {
				 altaOfferId = altaOfferRepository.findByGapArpaAndSpeed(fijaProduct.getOriginOfferType(), gapArpa, gapSpeed, cluster);
			    }
			    
			    //TODO CONFIMAR SI ES CON LA CONSULTA ANTERIOR O CodOferta_elegibleMT 

			    if (Boolean.FALSE.equals(StringUtil.isNullOrEmpty(altaOfferId))) {
				
				Offeringquad offeringquad = offeringquadRepository.findByOfferingquadIdAndTipoParrilla(elegibleOffersMt.getCodOffer(), "3");
				
				if (Boolean.FALSE.equals(StringUtil.isNullOrEmpty(offeringquad.getOfferingquadId()))) {
				    ClientTenureResponse recurringPriceResponse = clientMaintainTenure.getClientTenure(fijaProduct,
					    elegibleOffersMt);

				    Float recurringPrice = (float) 0;
				    Float tvEstelar = (float) 0 ;

				    if ("Y".equalsIgnoreCase(fijaProduct.getTvType())) {
					// TODO FALTA UNA VARIABLE
					tvEstelar = (float) 20;
//					recurringPrice = recurringPriceResponse.getRepeaterSvaAdicPrice()
//						+ recurringPriceResponse.getRepeaterSvaAdicPrice() + tvEstelar;
				    }else {
//					recurringPrice = recurringPriceResponse.getRepeaterSvaAdicPrice()
//						+ recurringPriceResponse.getRepeaterSvaAdicPrice() + tvEstelar;
				    }
					
					// TODO 
				 
				    
				}

				
			    }
			});

		    }
		    

		}
	    }
	}

    }

    @Test
    private String clusterTest(PublicIdResponse publicIdResponse, FijaProduct fijaProduct, MobileProduct mobileProduct) {

	String cluster = null;

	if (StringUtil.isNullOrEmpty(publicIdResponse.getServiceBbFija()) && StringUtil.isNullOrEmpty(publicIdResponse.getServiceTvFija())
		&& StringUtil.isNullOrEmpty(publicIdResponse.getFijaLine())) {

	    if ("1".equalsIgnoreCase(mobileProduct.getMobilePlantType())) {

		if ("1".equalsIgnoreCase(mobileProduct.getMobileLineType())) {
		    cluster = "SoloMovil";
		} else if ("2".equalsIgnoreCase(mobileProduct.getMobileLineType())) {
		    cluster = "SoloPrepago";
		}
	    }

	} else {

	    if ("1".equalsIgnoreCase(fijaProduct.getFijaPlantType())) {

		if (publicIdResponse.getMobileLine() == null || publicIdResponse.getMobileLine().isEmpty()) {

		    if ("N".equalsIgnoreCase(fijaProduct.getPortabilityFijaIndicator())) {
			cluster = "SoloFija";
		    } else if ("Y".equalsIgnoreCase(fijaProduct.getPortabilityFijaIndicator())) {
			cluster = "Totalizados Porta";
		    }

		} else {

		    if ("N".equalsIgnoreCase(fijaProduct.getPortabilityFijaIndicator())
			    && "N".equalsIgnoreCase(mobileProduct.getPortabilityMobileIndicator())) {
			cluster = "SoloFija";
		    } else {
			cluster = "Totalizados Porta";
		    }
		}

	    }
	}

	return cluster;
    }

    @Test
    private ClientTenure repeaterTenue(String idReapeterOrigin, String idSvaBbElegibleMt, String codFijaElegibleMt) {

	ClientTenure repeaterResponse = new ClientTenure();

	if (!idReapeterOrigin.equals(idSvaBbElegibleMt)) {

	    RelationsMaster relationsMaster = relationsMasterRepository.findByRootCidAndParentId(codFijaElegibleMt, idReapeterOrigin);

	    if (!StringUtil.isNullOrEmpty(relationsMaster.getChildId())) {
		repeaterResponse.setId("34105211");
		repeaterResponse.setName("Ultra WiFi");
		repeaterResponse.setProductType(ProductTypeEnum.DEVICE);
	    }

	}

	return repeaterResponse;
    }

    @Test
    private ClientTenure modemTenue(String internetTechnologyOrigin, String typeModemOrigin, ElegibleOffersMt elegibleOffersMt) {

	ClientTenure clientTenure = new ClientTenure();
	ProductCharacteristic productCharacteristic = new ProductCharacteristic();

	// if (("ADSL".equalsIgnoreCase(internetTechnology) &&
	// "HFC".equalsIgnoreCase(internetTechnologyElegibleMt) ||
	// "FTTH".equalsIgnoreCase(internetTechnologyElegibleMt)) ||
	// ("HFC".equalsIgnoreCase(internetTechnology) &&
	// "FTTH".equalsIgnoreCase(internetTechnologyElegibleMt)) ) {
	//
	//
	// }

	if (elegibleOffersMt.getInternetTechnology().equalsIgnoreCase(internetTechnologyOrigin)) {
	    if (elegibleOffersMt.getSvaTypeEq().equalsIgnoreCase(typeModemOrigin)) {
		clientTenure.setId("3192652");
		clientTenure.setName(typeModemOrigin);
		clientTenure.setProductType(ProductTypeEnum.DEVICE);
		productCharacteristic.setId("Equipment_Sub_Type");
		productCharacteristic.setName("Sub Tipo de Equipo");
		productCharacteristic.setValue("SubTipo_Modem_Origen");
		productCharacteristic.setValueType(ValueTypeEnum.STRINGWRAPPER);
		clientTenure.setProductCharacteristic(productCharacteristic);
	    }
	}

	return clientTenure;
    }

    @Test
    private ClientTenure decoTenue(String tvTechnologyOrigin, List<String> typeDecoOriginList, ElegibleOffersMt elegibleOffersMt) {

	ClientTenure clientTenure = new ClientTenure();
	ProductCharacteristic productCharacteristic = new ProductCharacteristic();

	if (!("DTH".equalsIgnoreCase(tvTechnologyOrigin) && "CATV".equalsIgnoreCase(elegibleOffersMt.getTvTechnology()))) {

	    Integer numOriginDecoHd = 0;
	    Integer numOriginDecoSd = 0;

	    for (String typeDecoOrigin : typeDecoOriginList) {
		if ("HD".equalsIgnoreCase(typeDecoOrigin)) {
		    numOriginDecoHd += 1;
		}
		if ("SD".equalsIgnoreCase(typeDecoOrigin)) {
		    numOriginDecoSd += 1;
		}
	    }

	    Integer numElegibleMtDecoHd = 0;
	    Integer numElegibleMtDecoSd = 0;

	    for (String typeDecoOrigin : elegibleOffersMt.getSvaTypeTvDeco()) {
		if ("HD".equalsIgnoreCase(typeDecoOrigin)) {
		    numElegibleMtDecoHd += 1;
		}
		if ("SD".equalsIgnoreCase(typeDecoOrigin)) {
		    numElegibleMtDecoSd += 1;
		}
	    }

	    if ((numOriginDecoHd > numElegibleMtDecoHd) || (numOriginDecoSd > numElegibleMtDecoSd)) {

		clientTenure.setId("3197701");
		clientTenure.setName("Caption_Deco_Origen");
		clientTenure.setProductType(ProductTypeEnum.DEVICE);
		productCharacteristic.setId("STB_Type");
		productCharacteristic.setName("Tipo de Decodificador");
		productCharacteristic.setValueType(ValueTypeEnum.STRINGWRAPPER);

		String decoType = null;

		if (numOriginDecoHd > numElegibleMtDecoHd) {

		    decoType = "HD";

		}

		if (numOriginDecoSd > numElegibleMtDecoSd) {

		    decoType = "SD";

		}

		productCharacteristic.setValue(decoType);
		clientTenure.setProductCharacteristic(productCharacteristic);

	    }

	}

	return clientTenure;
    }

    // Validar por fuera Si el cliente no tiene bloque tv.
    @Test
    private ClientTenure blockTenue(FijaProduct fijaProduct, ElegibleOffersMt elegibleOffersMt) {

	ClientTenure clientTenure = new ClientTenure();
	ProductCharacteristic productCharacteristic = new ProductCharacteristic();

	Integer index = 0;

	for (String codeBlockTvOrigin : fijaProduct.getCodeTvBlockOrigin()) {
	    // TODO PROBAR EL INDICE
	    index += 1;

	    if (!elegibleOffersMt.getCodSvaTvBlock().contains(codeBlockTvOrigin)) {
		RelationsMaster relationsMaster = relationsMasterRepository
			.findByRootCidAndChildIdAndParentId(elegibleOffersMt.getCodFija(), codeBlockTvOrigin, "3196671");

		if (!StringUtil.isNullOrEmpty(relationsMaster.getChildId())) {
		    clientTenure.setId(fijaProduct.getCodParentTvBlockOrigin());
		    clientTenure.setName("Bloque de Canales");
		    clientTenure.setProductType(ProductTypeEnum.SVA);
		    productCharacteristic.setId(relationsMaster.getChildId());
		    productCharacteristic.setName("Billing Offer");
		    productCharacteristic.setValue(fijaProduct.getNameTvBlockOrigin().get(index));
		    productCharacteristic.setValueType(ValueTypeEnum.STRINGWRAPPER);
		    clientTenure.setProductCharacteristic(productCharacteristic);

		}
	    }

	}

	return clientTenure;
    }

}
