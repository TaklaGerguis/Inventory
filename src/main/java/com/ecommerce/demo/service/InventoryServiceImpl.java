package com.ecommerce.demo.service;

import com.ecommerce.demo.dao.InventoryDAO;
import com.ecommerce.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {


//    private AdviceLineService adviceLineService;
    private InventoryDAO inventoryRepository;
//    private OrderLineService orderLineService;
//    private AdviceService adviceService;
//    private OrderService orderService;

    @Autowired
    public InventoryServiceImpl(InventoryDAO inventoryRepository) {

        this.inventoryRepository = inventoryRepository;
       // this.adviceLineService = adviceLineService;
//        this.orderLineService = orderLineService;
//        this.adviceService = adviceService;
//        this.orderService = orderService;
    }

    @Override
    @Transactional
    public List<Inventory> findAll() {

        return inventoryRepository.findAll();
    }

    @Override
    @Transactional
    public Inventory findById(Long id) {

        return inventoryRepository.findById(id);
    }

//    @Override
//    public List<Inventory> findBySku(Sku sku) {
//
//        List<Inventory> inventories = inventoryRepository.findBySku(sku);
//
//        return inventories;
//    }
//
//    @Override
//    public Inventory findByQuantityUnit(QuantityUnit quantityUnit) {
//
//        Inventory inventory = inventoryRepository.findByQuantityUnit(quantityUnit);
//
//        return inventory;
//    }
//
//    @Override
//    public Inventory findBySkuAndQuantityUnit(Sku sku, QuantityUnit quantityUnit) {
//
//        return inventoryRepository.findBySkuAndQuantityUnit(sku, quantityUnit);
//    }
//
//    @Override
//    @Scheduled(cron = "0 0 18 * * MON-FRI")
//    public void executeInvoice() {
//
//        List<Advice> advices = adviceService.findAdvicesByStatus(Advice.Status.PENDING);
//
//        for (Advice advice : advices) {
//
//            List<AdviceLine> adviceLines = adviceLineService
//                    .findAdviceLinesByAdviceAndStatus(advice, Status.PENDING);
//
//            for (AdviceLine adviceLine : adviceLines) {
//                executeAdviceLine(adviceLine);
//            }
//
//            List<AdviceLine> adviceLinesByAdviceAndStatus =
//                    adviceLineService.findAdviceLinesByAdviceAndStatus(advice, Status.PENDING);
//
//            if (adviceLinesByAdviceAndStatus.isEmpty()) {
//
//                advice.setStatus(Advice.Status.COMPLETED);
//            }
//        }
//
//        List<Order> orders = orderService.findOrdersByStatus(Order.Status.PENDING);
//
//        for (Order order : orders) {
//
//            List<OrderLine> orderLines = orderLineService
//                    .findOrderLinesByOrderAndStatus(order, OrderLine.Status.PENDING);
//
//            for (OrderLine orderLine : orderLines) {
//                executeOrderLine(orderLine);
//            }
//
//            if (orderLineService.findOrderLinesByOrderAndStatus(order, OrderLine.Status.PENDING) == null) {
//
//                order.setStatus(Order.Status.COMPLETED);
//            }
//        }
//    }
//
//    @Override
//    public Inventory executeAdviceLine(AdviceLine adviceLine) {
//
//        Sku sku = adviceLine.getSku();
//
//        QuantityUnit quantityUnit = adviceLine.getQuantityUnit();
//
//        Inventory inventory = inventoryRepository.findBySkuAndQuantityUnit(sku, quantityUnit);
//
//        if (adviceLine.getStatus() == Status.PENDING) {
//
//            if (inventory == null) {
//
//                inventory = new Inventory(sku, quantityUnit, 0, adviceLine.getExpDate());
//            }
//
//            inventory.setCurrentQuantity(inventory.getCurrentQuantity() + adviceLine.getQuantity());
//
//            inventory.setBestBy(adviceLine.getExpDate());
//
//            adviceLine.setStatus(Status.COMPLETED);
//
//            adviceLineService.save(adviceLine);
//
//            inventoryRepository.save(inventory);
//
//        }
//
//        return inventory;
//    }
//
//    @Override
//    public Inventory executeOrderLine(OrderLine orderLine) {
//
//        Sku sku = orderLine.getSku();
//
//        QuantityUnit quantityUnit = orderLine.getQuantityUnit();
//
//        Inventory inventory = findBySkuAndQuantityUnit(sku, quantityUnit);
//
//        if (orderLine.getStatus() == OrderLine.Status.PENDING) {
//
//            if (inventory != null && inventory.getCurrentQuantity() >= orderLine.getQuantity()
//                    && inventory.getBestBy().compareTo(orderLine.getExpDate()) <= 0) {
//
//                inventory.setCurrentQuantity(inventory.getCurrentQuantity() - orderLine.getQuantity());
//
//                orderLine.setStatus(OrderLine.Status.COPMLETED);
//
//                orderLineService.save(orderLine);
//
//                inventoryRepository.save(inventory);
//
//            }
//        }
//        return inventory;
//    }
//
    @Override
    @Transactional
    public Inventory save(Inventory inventory) {

        return inventoryRepository.save(inventory);
    }
//
//    @Override
//    public void deleteById(Long id) {
//
//        inventoryRepository.deleteById(id);
//    }

}
