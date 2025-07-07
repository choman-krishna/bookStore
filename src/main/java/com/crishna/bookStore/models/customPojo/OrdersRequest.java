package com.crishna.bookStore.models.customPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersRequest {

    private int userId;
    private List<OrderedItems> orderedItemsList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderedItems {
        int bookId;
        int quantity;
    }


}
