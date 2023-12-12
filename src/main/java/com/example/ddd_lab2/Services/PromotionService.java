package com.example.ddd_lab2.Services;


import com.example.ddd_lab2.Aggregates.Promotion;
import com.example.ddd_lab2.Repositories.PromotionRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {
    private final PromotionRepo promotionRepository;
    public PromotionService(PromotionRepo promotionRepository) {
        this.promotionRepository = promotionRepository;
    }



    public Promotion createPromotion(String promotionName, String startDate, String endDate) {
        Promotion promotion = new Promotion();
        promotion.setPromotionName(promotionName);
        promotion.setStartDate(LocalDate.parse(startDate));
        promotion.setEndDate(LocalDate.parse(endDate));
        return promotionRepository.saveAndFlush(promotion);
    }

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion getPromotionById(Long promotionId) {
        Optional<Promotion> promotionOptional = promotionRepository.findById(promotionId);
        return promotionOptional.orElse(null);
    }

    public void deletePromotion(Long promotionId) {
        promotionRepository.deleteById(promotionId);
    }
}