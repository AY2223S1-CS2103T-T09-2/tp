package seedu.address.model.order;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDate;
import java.util.Objects;

import seedu.address.model.person.Buyer;

/**
 * Abstracts an order.
 */
public class Order {

    private Buyer buyer;
    private final PriceRange requestedPriceRange;
    private final Request request;
    private final AdditionalRequests additionalRequests;
    private final LocalDate byDate;
    private final Price settledPrice;
    private final OrderStatus status;

    /**
     * Constructs an order object.
     *
     * @param buyer The buyer who initiates the request.
     * @param requestedPriceRange The acceptable price range during negotiation.
     * @param request The description of the request, that is, what kind of pet the buyer wants.
     * @param additionalRequests Some other requests in string.
     * @param byDate The date before which the order should be dealt.
     * @param settledPrice The settled final price.
     * @param status Whether this order is under negotiation, or finished, or is being delivered, etc.
     */
    public Order(Buyer buyer,
                 PriceRange requestedPriceRange,
                 Request request,
                 AdditionalRequests additionalRequests,
                 LocalDate byDate,
                 Price settledPrice,
                 OrderStatus status) {
        requireAllNonNull(status);
        this.buyer = buyer;
        this.requestedPriceRange = requestedPriceRange;
        this.request = request;
        this.additionalRequests = additionalRequests;
        this.byDate = byDate;
        this.settledPrice = settledPrice;
        this.status = status;
    }

    /**
     * Constructs an order object.
     * The status is by default Pending.
     *
     * @param buyer The buyer who initiates the request.
     * @param requestedPriceRange The acceptable price range during negotiation.
     * @param request The description of the request, that is, what kind of pet the buyer wants.
     * @param additionalRequests Some other requests in string.
     * @param byDate The date before which the order should be dealt.
     * @param settledPrice The settled final price.
     */
    public Order(Buyer buyer,
                 PriceRange requestedPriceRange,
                 Request request,
                 AdditionalRequests additionalRequests,
                 LocalDate byDate,
                 Price settledPrice) {
        this.buyer = buyer;
        this.requestedPriceRange = requestedPriceRange;
        this.request = request;
        this.additionalRequests = additionalRequests;
        this.byDate = byDate;
        this.settledPrice = settledPrice;
        status = OrderStatus.PENDING;
    }

    /**
     * Sets the buyer of this order.
     *
     * @param buyer The buyer to be set.
     */
    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    /**
     * Gets the buyer
     *
     * @return The buyer of this order.
     */
    public Buyer getBuyer() {
        return buyer;
    }

    /**
     * Gets the price range of the order.
     *
     * @return The price range.
     */
    public PriceRange getRequestedPriceRange() {
        return requestedPriceRange;
    }

    /**
     * Gets the request of the order.
     *
     * @return The request.
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Gets the additional requests of the order.
     *
     * @return The additional request.
     */
    public AdditionalRequests getAdditionalRequests() {
        return additionalRequests;
    }

    /**
     * Gets the date of the order.
     *
     * @return The date in {@code LocalDate}.
     */
    public LocalDate getByDate() {
        return byDate;
    }

    /**
     * Gets the settled price of the order.
     *
     * @return The price.
     */
    public Price getSettledPrice() {
        return settledPrice;
    }

    /**
     * Gets the status of the order.
     *
     * @return The status.
     */
    public OrderStatus getOrderStatus() {
        return status;
    }

    /**
     * Update the price range changed during negotiation.
     *
     * @param upperBound The price is not greater than it.
     * @param lowerBound The price is not smaller than it.
     */
    public void updateRequestedPriceRange(Price upperBound, Price lowerBound) {
        requestedPriceRange.updatePriceRange(upperBound, lowerBound);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other instanceof Order) {
            Order otherOrder = (Order) other;
            return buyer.equals(otherOrder.getBuyer())
                    && requestedPriceRange.equals(otherOrder.getRequestedPriceRange())
                    && request.equals(otherOrder.getRequest())
                    && additionalRequests.equals(otherOrder.getAdditionalRequests())
                    && byDate.equals(otherOrder.getByDate())
                    && settledPrice.equals(otherOrder.getSettledPrice())
                    && status.equals(otherOrder.getOrderStatus());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyer, requestedPriceRange, request,
                additionalRequests, byDate, settledPrice, status);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("RequestedPriceRange: ").append(getRequestedPriceRange())
                .append(System.lineSeparator())
                .append("Process order by: ").append(getByDate())
                .append(System.lineSeparator())
                .append("=== Request ===").append(System.lineSeparator())
                .append(request.toString()).append(System.lineSeparator())
                .append("==========").append(System.lineSeparator())
                .append("=== Additional Requests ===").append(System.lineSeparator())
                .append(additionalRequests.toString()).append(System.lineSeparator())
                .append("==========").append(System.lineSeparator())
                .append("Settled price: ").append(getSettledPrice())
                .append(System.lineSeparator())
                .append("Status: ").append(getOrderStatus());
        return builder.toString();

        //TODO Uncomment this
        //        StringBuilder builder = new StringBuilder();
        //        builder.append("RequestedPriceRange: ").append(getRequestedPriceRange())
        //                .append(System.lineSeparator())
        //                .append("Process order by: ").append(getByDate())
        //                .append(System.lineSeparator())
        //                .append("=== Request ===").append(System.lineSeparator())
        //                .append(request.toString()).append(System.lineSeparator())
        //                .append("==========").append(System.lineSeparator())
        //                .append("=== Additional Requests ===").append(System.lineSeparator())
        //                .append(additionalRequests.toString()).append(System.lineSeparator())
        //                .append("==========").append(System.lineSeparator())
        //                .append("Settled price: ").append(getSettledPrice())
        //                .append("Status: ").append(getOrderStatus());
        //        return builder.toString();

    }

}
