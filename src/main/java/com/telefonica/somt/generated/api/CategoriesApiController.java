package com.telefonica.somt.generated.api;

import com.telefonica.somt.generated.model.CategoryRequestType;
import com.telefonica.somt.generated.model.CategoryTreeRefType;
import com.telefonica.somt.generated.model.CategoryType;
import org.joda.time.DateTime;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

@Controller
public class CategoriesApiController implements CategoriesApi {



    public ResponseEntity<CategoryType> createCategory(@ApiParam(value = "New category in catalog" ,required=true ) @RequestBody CategoryRequestType category,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication) {
        // do some magic!
        return new ResponseEntity<CategoryType>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteCategory(@ApiParam(value = "ID of the category that needs to be fetched",required=true ) @PathVariable("categoryId") String categoryId,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<CategoryType>> getCategories(@ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
         @ApiParam(value = "To obtain the list of products matching to a given id in the other side mapping to the productId (to synchronize client and server identifiers) ") @RequestParam(value = "correlationId", required = false) String correlationId,
         @ApiParam(value = "to obtain the list of categories associated with a given name") @RequestParam(value = "name", required = false) String name,
         @ApiParam(value = "To obtain the categories that can be offered after this value") @RequestParam(value = "startDate", required = false) DateTime startDate,
         @ApiParam(value = "To obtain categories that can be offered before this value") @RequestParam(value = "endDate", required = false) DateTime endDate,
         @ApiParam(value = "To limit the amount of results") @RequestParam(value = "limit", required = false) String limit,
         @ApiParam(value = "To get the results starting from an offset value. Use for pagination") @RequestParam(value = "offset", required = false) String offset,
         @ApiParam(value = "To define the information elements expected in the response") @RequestParam(value = "fields", required = false) String fields) {
        // do some magic!
        return new ResponseEntity<List<CategoryType>>(HttpStatus.OK);
    }

    public ResponseEntity<CategoryType> retrieveCategory(@ApiParam(value = "ID of the category that needs to be fetched",required=true ) @PathVariable("categoryId") String categoryId,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
         @ApiParam(value = "To define the information elements expected in the response") @RequestParam(value = "fields", required = false) String fields) {
        // do some magic!
        return new ResponseEntity<CategoryType>(HttpStatus.OK);
    }

    public ResponseEntity<List<CategoryTreeRefType>> retrieveCategoryTree(@ApiParam(value = "ID of the category we want the tree to begin from. If the user needs the whole tree starting from all roots a hyphen (/categories/-/tree) could be used. Otherwise, an id should be provided and the tree that will be returned will be the one from that node downwards.",required=true ) @PathVariable("categoryId") String categoryId,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication) {
        // do some magic!
        return new ResponseEntity<List<CategoryTreeRefType>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> updateCategory(@ApiParam(value = "ID of the category that needs to be fetched",required=true ) @PathVariable("categoryId") String categoryId,
        @ApiParam(value = "Data for the category update" ,required=true ) @RequestBody CategoryRequestType category,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
