package com.kodilla.good.patterns.challenges.allegro;

public class ProductOrderService {
    private final InformationService informationService;
    private final OrderService orderService;
    private final ProductsRepository productsRepository;

    public ProductOrderService(final InformationService informationService,
                               final OrderService orderService,
                               final ProductsRepository productsRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.productsRepository = productsRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isPaid = orderService.validateTransaction(orderRequest.getUser(), orderRequest.getOrderedItems(),
                orderRequest.getDateOfOrder());

        if(isPaid) {
            informationService.inform(orderRequest.getUser());
            productsRepository.createOrder(orderRequest.getUser(), orderRequest.getOrderedItems(), orderRequest.getDateOfOrder());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}

