package org.example.fleetManagement.domainLayer;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Price implements Comparable<Price>{
    private final Integer amount;

    @Override
    public int compareTo(Price price) {
        return this.amount.compareTo(price.amount);
    }
}
