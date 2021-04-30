package com.devtest.lab02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devtest.lab02.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

}