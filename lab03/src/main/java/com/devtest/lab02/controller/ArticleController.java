package com.devtest.lab02.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devtest.lab02.exception.ResourceNotFoundException;
import com.devtest.lab02.model.Article;
import com.devtest.lab02.repository.ArticleRepository;

@RestController
@RequestMapping("/api")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/article")
    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable(value = "id") Long articleId)
        throws ResourceNotFoundException {
        Article article = articleRepository.findById(articleId)
          .orElseThrow(() -> new ResourceNotFoundException("Article not found for this id :: " + articleId));
        return ResponseEntity.ok().body(article);
    }
    
    
    @PostMapping("/article/creer")
    public Article createArticle(@Valid @RequestBody Article article) {
        return articleRepository.save(article);
    }
    

    @PutMapping("/article/modifier/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable(value = "id") Long articleId,
         @Valid @RequestBody Article articleDetails) throws ResourceNotFoundException {
        Article article = articleRepository.findById(articleId)
        .orElseThrow(() -> new ResourceNotFoundException("Article not found for this id :: " + articleId));

        article.setnom(articleDetails.getnom());
        article.setcode_barre(articleDetails.getcode_barre());
        article.setdescription(articleDetails.getdescription());
        article.setqte(articleDetails.getqte());
        article.setimage(articleDetails.getimage());
        final Article updatedArticle = articleRepository.save(article);
        return ResponseEntity.ok(updatedArticle);
    }

    @DeleteMapping("/article/supprimer/{id}")
    public Map<String, Boolean> deleteArticle(@PathVariable(value = "id") Long articleId)
            throws ResourceNotFoundException {
           Article article = articleRepository.findById(articleId)
          .orElseThrow(() -> new ResourceNotFoundException("Article not found for this id :: " + articleId));

        articleRepository.delete(article);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}