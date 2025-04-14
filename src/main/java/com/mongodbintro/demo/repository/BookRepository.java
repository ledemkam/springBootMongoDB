package com.mongodbintro.demo.repository;

import com.mongodbintro.demo.modell.entity.Book;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

public interface BookRepository extends MongoRepository<Book,String> {

    //ici on cree une methode personnalisée pour trouver un livre par son id
    //on utilise le nom de la methode pour que spring data mongodb puisse generer la requete

    //on peut aussi utiliser un parametre de requete: @Query pour definir la requete
    @Query(value = "{bookId :'?0'}")// ici on utilise le bookId comme parametre de la requete
    Book findBookByBookId(String bookId);

    @Query(value = "{bookId :{ $eq : ?0}")//
    @Update(pipeline = {"{'$set' : {'name' : ?1}}"})
    void updateBookNameByBookId(String bookId, String name);


    //ici on cree une methode personnalisée pour supprimer un livre par son id

    @DeleteQuery
    void deleteBookByBookId(String bookId);
}
