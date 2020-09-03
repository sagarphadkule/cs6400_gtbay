package com.gatech.cs6400.gtbay.resources.item;

import static com.gatech.cs6400.gtbay.constants.ResourceConstants.ADD_ITEM;
import static com.gatech.cs6400.gtbay.constants.ResourceConstants.ADD_RATING;
import static com.gatech.cs6400.gtbay.constants.ResourceConstants.BID_ITEM;
import static com.gatech.cs6400.gtbay.constants.ResourceConstants.BUY_ITEM;
import static com.gatech.cs6400.gtbay.constants.ResourceConstants.GET_ITEM_DETAILS;
import static com.gatech.cs6400.gtbay.constants.ResourceConstants.GET_RATINGS;
import static com.gatech.cs6400.gtbay.constants.ResourceConstants.ITEM;
import static com.gatech.cs6400.gtbay.constants.ResourceConstants.SEARCH_ITEMS;
import static com.gatech.cs6400.gtbay.constants.ResourceConstants.UPDATE_DESCRIPTION;

import com.gatech.cs6400.gtbay.models.domain.ItemDTO;
import com.gatech.cs6400.gtbay.models.rest.item.AddItemRequest;
import com.gatech.cs6400.gtbay.models.rest.item.BidRequest;
import com.gatech.cs6400.gtbay.models.rest.item.BuyRequest;
import com.gatech.cs6400.gtbay.models.rest.item.Rating;
import com.gatech.cs6400.gtbay.models.rest.item.SearchItemsRequest;
import com.gatech.cs6400.gtbay.models.rest.item.SearchItemsResponse;
import com.gatech.cs6400.gtbay.service.ItemService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ITEM)
public class ItemResource {

    @Autowired
    ItemService itemService;

    @PostMapping(value = ADD_ITEM,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> addItem(
        @RequestHeader("username") String username,
        @Valid @RequestBody AddItemRequest addItemRequest) {
        itemService.addItem(addItemRequest, username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = UPDATE_DESCRIPTION,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> updateDescription(
        @RequestHeader("username") String username,
        @PathVariable Integer itemId, @RequestBody String description) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = GET_ITEM_DETAILS, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ItemDTO> getItemDetails(
        @RequestHeader("username") String username,
        @PathVariable Integer itemId) {
//        ItemDetail detail = new ItemDetail();
//        detail.setId(1);
//        detail.setAuctionEndTime(new Date());
//        detail.setCategory("Electronics");
//        detail.setCondition("New");
//        detail.setDescription("LG 65 \" OLED TV");
//        detail.setName("LG TV");
//        detail.setGetItNowPrice(new BigDecimal("699"));
//        detail.setReturnable(false);
//        BidInfo bidInfo = new BidInfo();
//        bidInfo.setAmount(new BigDecimal("100"));
//        bidInfo.setBidder("john");
//        bidInfo.setTimestamp(new Date());
//        BidInfo bidInfo2 = new BidInfo();
//        bidInfo2.setAmount(new BigDecimal("200"));
//        bidInfo2.setBidder("Nellie");
//        bidInfo2.setTimestamp(new Date());
//        List<BidInfo> bidInfoList = new ArrayList<>();
//        bidInfoList.add(bidInfo);
//        bidInfoList.add(bidInfo2);
//        detail.setBidInfoList(bidInfoList);
//        if (itemId.equals(1)) {
//            return new ResponseEntity<>(detail, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        ItemDTO dto = itemService.getItem(itemId);
return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping(value = SEARCH_ITEMS, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<SearchItemsResponse>> searchItems(
        @RequestHeader("username") String username,
        @Valid @RequestBody SearchItemsRequest searchItemsRequest) {
        List<SearchItemsResponse> searchItemResponseList = new ArrayList();
        SearchItemsResponse response1 = new SearchItemsResponse();
        response1.setItemId(1);
        response1.setItemName("Samsung TV");
        response1.setCurrentBid(new BigDecimal("100"));
        response1.setGetItNowPrice(new BigDecimal("700"));
        response1.setHighBidder("Kevin");
        response1.setAuctionEndTime(new Date());
        SearchItemsResponse response2 = new SearchItemsResponse();
        response2.setItemId(2);
        response2.setItemName("LG TV");
        response2.setCurrentBid(new BigDecimal("200"));
        response2.setGetItNowPrice(new BigDecimal("800"));
        response2.setHighBidder("Kate");
        response2.setAuctionEndTime(new Date());
        searchItemResponseList.add(response1);
        searchItemResponseList.add(response2);
        return new ResponseEntity<>(searchItemResponseList, HttpStatus.OK);
    }

    @PostMapping(value = BID_ITEM, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> bidItem(
        @RequestHeader("username") String username,
        @PathVariable Integer itemId,
        @Valid @RequestBody BidRequest request) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = BUY_ITEM, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> buyItem(
        @RequestHeader("username") String username,
        @PathVariable Integer itemId,
        @RequestBody BuyRequest request) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = GET_RATINGS, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Rating>> getRatings(
        @RequestHeader("username") String username,
        @PathVariable Integer itemId) {
        if (itemId.equals(1)) {
            List ratingsList = new ArrayList();
            Rating r1 = new Rating();
            r1.setComment("Great");
            r1.setNumberOfStars(5);
            r1.setRatedBy("Jack");
            Rating r2 = new Rating();
            r2.setComment("Good");
            r2.setNumberOfStars(4);
            r2.setRatedBy("Arnold");
            ratingsList.add(r1);
            ratingsList.add(r2);
            return new ResponseEntity<>(ratingsList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = ADD_RATING, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> addRating(
        @RequestHeader("username") String username,
        @PathVariable Integer itemId,
        @RequestBody Rating rating) {
        return new ResponseEntity(HttpStatus.OK);
    }


}
