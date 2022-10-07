package org.example.fleetManagement.domainLayer;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Price implements Comparable<Price>{
    private final Integer amountPerHour;

    @Override
    public int compareTo(Price price) {
        return this.amountPerHour.compareTo(price.amountPerHour);
    }
}
