package com.telefonica.somt.business.variables.CustomerProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonica.somt.business.variables.CustomerProduct.fijaProduct.FijaProductVariable;
import com.telefonica.somt.business.variables.CustomerProduct.mobileProduct.MobileProductVariable;
import com.telefonica.somt.commons.Constant;
import com.telefonica.somt.dto.SuggestedOffersMtRequestDto;
import com.telefonica.somt.dto.productInventory.ProductInventoryResponseDto;
import com.telefonica.somt.pojo.clientTenure.PublicIdResponse;
import com.telefonica.somt.pojo.variables.productInventory.CustomerProduct;
import com.telefonica.somt.pojo.variables.productInventory.FijaProduct;
import com.telefonica.somt.pojo.variables.productInventory.MobileProduct;
import com.telefonica.somt.proxy.productInventory.ProductInventoryConnection;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: Octubre 2020
 * @FileName: CustomerProductVariable.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase que obtiene las variables relacionadas a la tenencia
 *               actual (producto origen) del cliente
 */
@Component
public class CustomerProductVariable {

    @Autowired
    private ProductInventoryConnection parqueUnificadoConnection;
    @Autowired
    private FijaProductVariable	       fijaProductVariable;
    @Autowired
    private MobileProductVariable      mobileProductVariable;

    /**
     * Metodo principal. Obtiene variables de tenencia movil y fija del cliente.
     * 
     * @param request:
     *            request que viene del front
     * @param publicIdResponse:
     *            Objeto con los publicId de acuerdo al servicio
     * @return CustomerProduct : Retorna el producto fija y una lista de movil
     */
    public CustomerProduct getCustomerProductVariable(SuggestedOffersMtRequestDto request, PublicIdResponse publicIdResponse) {

	List<ProductInventoryResponseDto> customerTenancy = parqueUnificadoConnection.callRestService(request.getNationalId(),
		request.getNationalIdType());

	CustomerProduct customerProduct = new CustomerProduct();
	List<MobileProduct> mobileProductList = new ArrayList<>();

	FijaProduct fijaProduct = null;

	Integer numMobileLine = 0;

	for (ProductInventoryResponseDto product : customerTenancy) {

	    if (product.getProductType().equalsIgnoreCase(Constant.MOBILE)) {

		if (Boolean.FALSE.equals(publicIdResponse.getMobileLine() == null)
			&& Boolean.FALSE.equals(publicIdResponse.getMobileLine().isEmpty())) {

		    for (String publicIdMobile : publicIdResponse.getMobileLine()) {

			if (product.getPublicId().equals(publicIdMobile)) {
			    MobileProduct mobileProduct = mobileProductVariable.getMobileProduct(product, publicIdMobile);

			    if (mobileProduct.getMobileMtClient().equalsIgnoreCase(Constant.YES)) {
				numMobileLine += 1;
			    }
			    mobileProductList.add(mobileProduct);
			}

		    }
		}

	    } else {

		if (Objects.isNull(fijaProduct)) {
		    fijaProduct = fijaProductVariable.getFijaProduct(product, publicIdResponse.getPublicdIdFija());
		}

	    }

	}

	if (mobileProductList.size() == 1 && fijaProduct == null
		&& Constant.NO.equalsIgnoreCase(mobileProductList.get(0).getMobileMtClient())) {

	    mobileProductList.get(0).setOriginOfferType(Constant.SOLO_MOVIL);

	}

	customerProduct.setMobileProduct(mobileProductList);
	customerProduct.setNumMobileLine(numMobileLine);
	customerProduct.setFijaProduct(fijaProduct);

	return customerProduct;

    }

}
