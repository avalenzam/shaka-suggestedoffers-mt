package com.telefonica.somt.generated.api;

import org.joda.time.DateTime;
import com.telefonica.somt.generated.model.ProductCatalogUpdateType;
import com.telefonica.somt.generated.model.ProductRequestType;
import com.telefonica.somt.generated.model.ProductSpecificationType;

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

@Api(value = "products", description = "the products API")
public interface ProductsApi {

    @ApiOperation(value = "Create a new product", notes = "", response = ProductSpecificationType.class, tags={ "products", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Product created successfully", response = ProductSpecificationType.class) })
    @RequestMapping(value = "/products",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<ProductSpecificationType> createProduct(@ApiParam(value = "New product in catalog" ,required=true ) @RequestBody ProductRequestType productCreate,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication);


    @ApiOperation(value = "Retrieve a list of products", notes = "", response = ProductSpecificationType.class, responseContainer = "List", tags={ "products", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Products retrieved successfully", response = ProductSpecificationType.class) })
    @RequestMapping(value = "/products",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ProductSpecificationType>> getProducts(@ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
         @ApiParam(value = "To obtain the list of products matching to a given id in the other side mapping to the productId (to synchronize client and server identifiers) ") @RequestParam(value = "correlationId", required = false) String correlationId,
         @ApiParam(value = "to obtain the list of products associated with a given name ") @RequestParam(value = "name", required = false) String name,
         @ApiParam(value = "to obtain the list of products that are either single product or bundle of a set of single products") @RequestParam(value = "isBundle", required = false) Boolean isBundle,
         @ApiParam(value = "To obtain products with a specific status", allowableValues = "DRAFT, ACTIVE, EXPIRED") @RequestParam(value = "lifeCycleStatus", required = false) String lifeCycleStatus,
         @ApiParam(value = "To obtain the list of products belonging to a given class referenced by an id ") @RequestParam(value = "categoryId", required = false) String categoryId,
         @ApiParam(value = "To obtain the list of offerings belonging to a given class referenced by name") @RequestParam(value = "categoryName", required = false) String categoryName,
         @ApiParam(value = "To obtain the list of products that are served by the same provider") @RequestParam(value = "brand", required = false) String brand,
         @ApiParam(value = "To obtain the list of products that are assigned a given commercial code by the provider") @RequestParam(value = "productNumber", required = false) String productNumber,
         @ApiParam(value = "To obtain the list of products that are related to an specific product in the catalog") @RequestParam(value = "relatedProductId", required = false) String relatedProductId,
         @ApiParam(value = "To obtain the offerings that can be offered after this value") @RequestParam(value = "startDate", required = false) DateTime startDate,
         @ApiParam(value = "To obtain offerings that can be offered before this value") @RequestParam(value = "endDate", required = false) DateTime endDate,
         @ApiParam(value = "To limit the amount of results") @RequestParam(value = "limit", required = false) String limit,
         @ApiParam(value = "To get the results starting from an offset value. Use for pagination") @RequestParam(value = "offset", required = false) String offset,
         @ApiParam(value = "To define the information elements expected in the response") @RequestParam(value = "fields", required = false) String fields);


    @ApiOperation(value = "Modify a product", notes = "", response = Void.class, tags={ "products", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Product modified successfully", response = Void.class),
        @ApiResponse(code = 204, message = "Product modified successfully", response = Void.class) })
    @RequestMapping(value = "/products/{productId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> modifyProduct(@ApiParam(value = "ID of the product that needs to be modified",required=true ) @PathVariable("productId") String productId,
        @ApiParam(value = "Data for the product modification" ,required=true ) @RequestBody ProductRequestType productCreate,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication);


    @ApiOperation(value = "Retrieve a product", notes = "", response = ProductSpecificationType.class, tags={ "products", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Product retrieved successfully", response = ProductSpecificationType.class) })
    @RequestMapping(value = "/products/{productId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ProductSpecificationType> retrieveProductInformation(@ApiParam(value = "ID of the product that needs to be fetched",required=true ) @PathVariable("productId") String productId,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
         @ApiParam(value = "To define the information elements expected in the response") @RequestParam(value = "fields", required = false) String fields);


    @ApiOperation(value = "Modify all products", notes = "", response = Void.class, tags={ "products", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Products modified successfully", response = Void.class),
        @ApiResponse(code = 204, message = "Products modified successfully", response = Void.class) })
    @RequestMapping(value = "/products",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateCatalog(@ApiParam(value = "Data for the product update" ,required=true ) @RequestBody ProductCatalogUpdateType productCatalogUpdate,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication);

}
