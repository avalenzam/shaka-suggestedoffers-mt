package com.telefonica.somt.generated.api;

import java.math.BigDecimal;
import com.telefonica.somt.generated.model.ComponentProdOfferPriceType;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import com.telefonica.somt.generated.model.OfferingCatalogUpdateType;
import com.telefonica.somt.generated.model.OfferingRequestType;
import com.telefonica.somt.generated.model.OfferingType;
import com.telefonica.somt.generated.model.ResponseType;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

@Api(value = "offerings", description = "the offerings API")
public interface OfferingsApi {

    @ApiOperation(value = "Create a new offering", notes = "", response = OfferingType.class, tags={ "offerings", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Offering created successfully", response = OfferingType.class) })
    @RequestMapping(value = "/offerings",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<OfferingType> creatsomtfering(@ApiParam(value = "New offering" ,required=true ) @RequestBody OfferingRequestType offeringCreate,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication);


    @ApiOperation(value = "Retrieve a list of offerings", notes = "", response = ResponseType.class, tags={ "offerings", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Offerings retrieved successfully", response = ResponseType.class) })
    @RequestMapping(value = "/offerings",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ResponseType> getOfferings(@ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
        @ApiParam(value = "Identificador del usuario del sistema y/o subsistema que inicia la petición"  ) @RequestHeader(value="UNICA-User", required=false) String unICAUser,
        @ApiParam(value = "Es la fecha y hora al momento de invocar al servicio por el consumidor"  ) @RequestHeader(value="UNICA-Timestamp", required=false) String unICATimestamp,
        @ApiParam(value = "Including the proof of access (using OAuth2.0 security model) to guarantee that the consumer has privileges to access the entity database"  ) @RequestHeader(value="Authorization", required=false) String authorization,
         @ApiParam(value = "Indica el tipo de oferta a obtener  Puede tomar dos valores: elegibles ,  sugeridas", allowableValues = "ELEGIBLES, SUGERIDAS") @RequestParam(value = "type", required = false) String type,
         @ApiParam(value = "To obtain the list of offerings matching to a given id in the other side mapping to the offeringId (to synchronize client and server identifiers) ") @RequestParam(value = "correlationId", required = false) String correlationId,
         @ApiParam(value = "to obtain the list of offerings associated with a given name ") @RequestParam(value = "name", required = false) String name,
         @ApiParam(value = "to obtain the list of offerings that are either single offering or bundle of a set of single offerings") @RequestParam(value = "isBundle", required = false) Boolean isBundle,
         @ApiParam(value = "To obtain offerings with a specific status", allowableValues = "DRAFT, ACTIVE, EXPIRED") @RequestParam(value = "lifeCycleStatus", required = false) String lifeCycleStatus,
         @ApiParam(value = "To obtain the list of offerings belonging to a given category referenced by an id ") @RequestParam(value = "categoryId", required = false) String categoryId,
         @ApiParam(value = "To obtain the list of offerings belonging to a given category referenced by name") @RequestParam(value = "categoryName", required = false) String categoryName,
         @ApiParam(value = "To obtain the list of offerings belonging to a given subcategory (second or greater levelcategory) referenced by an id ") @RequestParam(value = "subcategoryId", required = false) String subcategoryId,
         @ApiParam(value = "To obtain the list of offerings belonging to a given subcategory (second or greater levelcategory) referenced by name") @RequestParam(value = "subcategoryName", required = false) String subcategoryName,
         @ApiParam(value = "To obtain the list of offerings belonging to a given channel referenced by id ") @RequestParam(value = "channelId", required = false) String channelId,
         @ApiParam(value = "To obtain the list of offerings belonging to a given channel referenced by name") @RequestParam(value = "channelName", required = false) String channelName,
         @ApiParam(value = "to obtain the list of offerings that include a given product specification (identified by id) within the list of composing products") @RequestParam(value = "productSpecificationId", required = false) String productSpecificationId,
         @ApiParam(value = "to obtain the list of offerings that include a given product specification (identified by name) within the list of composing products") @RequestParam(value = "productSpecificationName", required = false) String productSpecificationName,
         @ApiParam(value = "to obtain the list of offerings that are part of a given framework agreement") @RequestParam(value = "frameworkAgreeementId", required = false) String frameworkAgreeementId,
         @ApiParam(value = "to obtain the list of offerings that are targeted to an specific customer") @RequestParam(value = "customerId", required = false) String customerId,
         @ApiParam(value = "to obtain the list of offerings that are targeted to an specific account") @RequestParam(value = "accountId", required = false) String accountId,
         @ApiParam(value = "to obtain the list of offerings that are targeted to an specific instantiated product in the inventory for an specific product type") @RequestParam(value = "productType", required = false) String productType,
         @ApiParam(value = "to obtain the list of offerings that are targeted to an specific instantiated product in the inventory for an specific product identified with the internal id used by the server. This is typically used together with product.type") @RequestParam(value = "productId", required = false) String productId,
         @ApiParam(value = "to obtain the list of offerings that are targeted to an specific instantiated product in the inventory for an specific product identified with the public number associated to the product (e.g.: use of an msisdn to refer to a subscription to a mobileline product). This is typically used together with product.type") @RequestParam(value = "productPublicId", required = false) String productPublicId,
         @ApiParam(value = "To obtain the offerings that can be offered after this value") @RequestParam(value = "startDate", required = false) DateTime startDate,
         @ApiParam(value = "To obtain offerings that can be offered before this value") @RequestParam(value = "endDate", required = false) DateTime endDate,
         @ApiParam(value = "To limit the amount of results") @RequestParam(value = "limit", required = false) String limit,
         @ApiParam(value = "To get the results starting from an offset value. Use for pagination") @RequestParam(value = "offset", required = false) String offset,
         @ApiParam(value = "To retrieve offerings with prices returned in a specific currency") @RequestParam(value = "productOfferingPricePriceUnits", required = false) String productOfferingPricePriceUnits,
         @ApiParam(value = "To retrieve offerings with prices applying the change rate of a specific past date") @RequestParam(value = "productOfferingPriceCurrencyChangeDate", required = false) DateTime productOfferingPriceCurrencyChangeDate,
         @ApiParam(value = "To retrieve offerings with prices that are valid after this date") @RequestParam(value = "productOfferingPriceStartPriceDate", required = false) DateTime productOfferingPriceStartPriceDate,
         @ApiParam(value = "To retrieve offerings with prices that are valid before this date") @RequestParam(value = "productOfferingPriceEndPriceDate", required = false) DateTime productOfferingPriceEndPriceDate,
         @ApiParam(value = "To retrieve offerings with prices of the item when bought by a specific consumer e.g.: Buying a VM from Brazil (type=OB) or purchasing a plan by a VIP customer (type=customer)") @RequestParam(value = "productOfferingPricePriceConsumerEntityType", required = false) String productOfferingPricePriceConsumerEntityType,
         @ApiParam(value = "To retrieve offerings with prices of the item when bought by a specific consumer e.g.: Buying a VM from Brazil (id=BR) or purchasing a plan by a VIP customer (id=CustomerId).") @RequestParam(value = "productOfferingPricePriceConsumerId", required = false) String productOfferingPricePriceConsumerId,
         @ApiParam(value = "To retrieve offerings with prices of the item in a specific region e.g.: a VM deployed in USA.") @RequestParam(value = "productOfferingPricePriceLocation", required = false) String productOfferingPricePriceLocation,
         @ApiParam(value = "Es el precio del rango inicial de la oferta") @RequestParam(value = "productOfferingPriceStartPriceAmout", required = false) BigDecimal productOfferingPriceStartPriceAmout,
         @ApiParam(value = "Es el precio del rango final de la oferta") @RequestParam(value = "productOfferingPriceEndPriceAmout", required = false) BigDecimal productOfferingPriceEndPriceAmout,
         @ApiParam(value = "To define the information elements expected in the response") @RequestParam(value = "fields", required = false) String fields,
         @ApiParam(value = "To filter offers that can be offered to a user with a credit score equal or greater to the one sent in this parameter. Credit Score is a measure of the creditworthiness calculated on the basis of a combination of factors such as their income and credit history.") @RequestParam(value = "creditScore", required = false) Integer creditScore,
         @ApiParam(value = "To filter offers that can be offered to a user with a credit limit equal or greater to the one sent in this parameter. Credit Limit is the maximum amount of money that may be charged on the customer's accounts and local currency is assumed") @RequestParam(value = "creditLimit", required = false) BigDecimal creditLimit,
         @ApiParam(value = "To filter offers that can be offered to a user in a certain site or store") @RequestParam(value = "siteId", required = false) String siteId,
         @ApiParam(value = "To filter offers that can be offered to a user in a site or store in a certain region") @RequestParam(value = "region", required = false) String region,
         @ApiParam(value = "To filter offers that can be offered to a user in a certain site or store in a state or province") @RequestParam(value = "stateOrProvince", required = false) String stateOrProvince,
         @ApiParam(value = "To filter offers that can be offered to a certain customer segment") @RequestParam(value = "customerSegment", required = false) String customerSegment,
         @ApiParam(value = "To filter offers that can be offered to a certain customer segment") @RequestParam(value = "customerSubsegment", required = false) String customerSubsegment,
         @ApiParam(value = "To filter offers that can be offered only for new customers coming from other operators (in case is set to true) or only for existing customers or fresh new customers (in case it is false)") @RequestParam(value = "isPortability", required = false) Boolean isPortability,
         @ApiParam(value = "Current plan type of the potential customer in external operator (only when isPortability=true)", allowableValues = "PREPAID, POSTPAID") @RequestParam(value = "portabilityCurrentPlanType", required = false) String portabilityCurrentPlanType,
         @ApiParam(value = "Date since the potential customer is with his current company. Used to filter offers depending on customer eagerness to churn. Use only when isPortability=true") @RequestParam(value = "portabilityCustomerSince", required = false) LocalDate portabilityCustomerSince,
         @ApiParam(value = "Current company of the potential customer. Use only when isPortability=true") @RequestParam(value = "portabilityCurrentCompany", required = false) String portabilityCurrentCompany,
         @ApiParam(value = "Dealer ID, in case this sale is being performed by a third party and not directly by Telef?nica.") @RequestParam(value = "dealerId", required = false) String dealerId,
         @ApiParam(value = "To query offers that include broadband products with a minimum download rate measured in mbps.") @RequestParam(value = "broadbandMinDlDataRate", required = false) Integer broadbandMinDlDataRate,
         @ApiParam(value = "To query offers that include broadband products with a maximum download rate measured in mbps.") @RequestParam(value = "broadbandMaxDlDataRate", required = false) Integer broadbandMaxDlDataRate,
         @ApiParam(value = "To query offers that include broadband products with a certain connection type.", allowableValues = "FIBER, DSL") @RequestParam(value = "broadbandConnection", required = false) String broadbandConnection,
         @ApiParam(value = "To filter offers that can be offered only for customers willing to churn to avoid so (in case is set to true) or for the rest (in case it is false)") @RequestParam(value = "isRetention", required = false) Boolean isRetention,
         @ApiParam(value = "Campo que permite buscar por id de ofertas. Este campo puede buscar por varias ofertas separadas por comas ','.") @RequestParam(value = "productOfferingCatalogId", required = false) String productOfferingCatalogId,
         @ApiParam(value = "Current offering Id. This offering is the one the user has currently instantiated and is to be replaced by any of the offerings returned by this operation") @RequestParam(value = "currentOffering", required = false) String currentOffering,
         @ApiParam(value = "currentOffering must be filled too if this query parameter is used. To filter offers that are more expensive (upsell, isUpgrade=true) or cheaper or the same (downsell, isUpgrade=false) than the customer's current offering") @RequestParam(value = "isUpgrade", required = false) Boolean isUpgrade,
         @ApiParam(value = "Filters offerings that are suitable to a certain action", allowableValues = "NEWSUBSCRIBER, OFFERINGCHANGE, ADDITIONALSERVICES") @RequestParam(value = "action", required = false) String action,
         @ApiParam(value = "Filters offerings that can be offered in a certain commercial area") @RequestParam(value = "commercialAreaId", required = false) String commercialAreaId,
         @ApiParam(value = "Es el id de la orden") @RequestParam(value = "productOrderId", required = false) String productOrderId,
         @ApiParam(value = "Es le id del plan") @RequestParam(value = "planId", required = false) String planId,
         @ApiParam(value = "Es el tipo de plan del producto") @RequestParam(value = "product", required = false) String product,
         @ApiParam(value = "Tipo de fuente, puede ser OFERTA, DISPOSITIVO") @RequestParam(value = "sourceType", required = false) String sourceType,
         @ApiParam(value = "Información para el serviceability") @RequestParam(value = "networkTechnology", required = false) String networkTechnology,
         @ApiParam(value = "Información para el serviceability") @RequestParam(value = "serviceabilityMaxSpeed", required = false) String serviceabilityMaxSpeed,
         @ApiParam(value = "Información para el serviceability") @RequestParam(value = "serviceabilityId", required = false) String serviceabilityId,
         @ApiParam(value = "Es el grupo del plan") @RequestParam(value = "planGroup", required = false) String planGroup,
         @ApiParam(value = "Es el plan rank inicial") @RequestParam(value = "planRankInitial", required = false) String planRankInitial,
         @ApiParam(value = "Es el plan rank de la oferta") @RequestParam(value = "planRank", required = false) String planRank,
         @ApiParam(value = "Es la duración del comprmiso del plan") @RequestParam(value = "planCommitmentDuration", required = false) String planCommitmentDuration,
         @ApiParam(value = "Nombre de la compañía a filtrar") @RequestParam(value = "invoiceCompany", required = false) String invoiceCompany,
         @ApiParam(value = "Es el subtipo de acción:   RO: Replace Offer CAPL: Cambio de Plan CAEQ: Cambio de equipo Este campo sera envia por el forntend") @RequestParam(value = "orderSubType", required = false) String orderSubType,
         @ApiParam(value = "Grupo valor del suscriptor") @RequestParam(value = "subscriberGroupValue", required = false) String subscriberGroupValue,
         @ApiParam(value = "Campo que me permite excluir ofertas de la lista de resultado. Es campo puede recibir mas de un id separado por ','") @RequestParam(value = "excludsomtfersId", required = false) String excludsomtfersId,
         @ApiParam(value = "Código de departamento de instalación incluido callao. Se utliza para obtener ofertas Fijas o Movistar Total  Puede tomar los valores 'ALL', '1','2',……'25' ") @RequestParam(value = "installationAddressDepartment", required = false) String installationAddressDepartment,
         @ApiParam(value = "") @RequestParam(value = "nationalID", required = false) String nationalID,
         @ApiParam(value = "") @RequestParam(value = "nationalIDType", required = false) String nationalIDType,
         @ApiParam(value = "Grupo valor del suscriptor") @RequestParam(value = "paginationInfoSize", required = false) Integer paginationInfoSize,
         @ApiParam(value = "Número de artículos en la página.") @RequestParam(value = "paginationInfoPageCount", required = false) Integer paginationInfoPageCount,
         @ApiParam(value = "Numero maximo de paginas") @RequestParam(value = "paginationInfoPage", required = false) Integer paginationInfoPage,
         @ApiParam(value = "Numero maximo de resultados") @RequestParam(value = "paginationInfoMaxResultCount", required = false) Integer paginationInfoMaxResultCount,
         @ApiParam(value = "Nombre de una propiedad que se utilizará para ordenar.") @RequestParam(value = "sortCriteriaName", required = false) String sortCriteriaName,
         @ApiParam(value = "Indica si esto es ascendente o descendente.") @RequestParam(value = "sortCriteriaAscending", required = false) Boolean sortCriteriaAscending);


    @ApiOperation(value = "Modify an offering", notes = "", response = Void.class, tags={ "offerings", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "No response was specified", response = Void.class) })
    @RequestMapping(value = "/offerings/{offeringId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> modifyOffering(@ApiParam(value = "ID of the offering that needs to be modified",required=true ) @PathVariable("offeringId") String offeringId,
        @ApiParam(value = "Data for the offering modification" ,required=true ) @RequestBody OfferingRequestType offeringCreate,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication);


    @ApiOperation(value = "Retrieve an offering", notes = "", response = OfferingType.class, tags={ "offerings", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Offering retrieved successfully", response = OfferingType.class) })
    @RequestMapping(value = "/offerings/{offeringId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<OfferingType> retrievsomtferingDetails(@ApiParam(value = "ID of the offering that needs to be fetched",required=true ) @PathVariable("offeringId") String offeringId,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
         @ApiParam(value = "To define the information elements expected in the response") @RequestParam(value = "fields", required = false) String fields);


    @ApiOperation(value = "Retrieve prices of an offering", notes = "", response = ComponentProdOfferPriceType.class, responseContainer = "List", tags={ "offerings", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Prices retrieved successfully", response = ComponentProdOfferPriceType.class) })
    @RequestMapping(value = "/offerings/{offeringId}/prices",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ComponentProdOfferPriceType>> retrievsomtferingPrices(@ApiParam(value = "ID of the offering that needs to be fetched",required=true ) @PathVariable("offeringId") String offeringId,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
         @ApiParam(value = "To retrieve prices that are valid after this date") @RequestParam(value = "startPriceDate", required = false) DateTime startPriceDate,
         @ApiParam(value = "To retrieve prices that are valid before this date") @RequestParam(value = "endPriceDate", required = false) DateTime endPriceDate,
         @ApiParam(value = "To retrieve prices in a specific currency") @RequestParam(value = "priceUnits", required = false) String priceUnits,
         @ApiParam(value = "To retrieve prices applying the change of a specific past date") @RequestParam(value = "currencyChangeDate", required = false) DateTime currencyChangeDate,
         @ApiParam(value = "To retrieve prices of the item in a specific region e.g.: a VM deployed in USA.") @RequestParam(value = "priceLocation", required = false) String priceLocation,
         @ApiParam(value = "To retrieve prices of the item when bought by a specific consumer e.g.: Buying a VM from Brazil (type=OB) or purchasing a plan by a VIP customer (type=customer)") @RequestParam(value = "priceConsumerEntityType", required = false) String priceConsumerEntityType,
         @ApiParam(value = "To retrieve prices of the item when bought by a specific consumer e.g.: Buying a VM from Brazil (id=BR) or purchasing a plan by a VIP customer (id=CustomerId).") @RequestParam(value = "priceConsumerId", required = false) String priceConsumerId,
         @ApiParam(value = "To define the information elements expected in the response") @RequestParam(value = "fields", required = false) String fields);


    @ApiOperation(value = "Modify all offerings", notes = "", response = Void.class, tags={ "offerings", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Offerings modified successfully", response = Void.class),
        @ApiResponse(code = 204, message = "Offerings modified successfully", response = Void.class) })
    @RequestMapping(value = "/offerings",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> updatsomtferingCatalog(@ApiParam(value = "Data for the catalog update" ,required=true ) @RequestBody OfferingCatalogUpdateType offeringCatalogUpdate,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication);

}
