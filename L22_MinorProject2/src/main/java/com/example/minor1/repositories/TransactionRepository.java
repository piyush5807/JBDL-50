package com.example.minor1.repositories;

import com.example.minor1.models.Book;
import com.example.minor1.models.Student;
import com.example.minor1.models.Transaction;
import com.example.minor1.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

//    @Query("select * from transaction where student_id = ?1 and book_id = ?2 and transactionType = ?3 order by id desc limit 1")
    Transaction findTopByStudentAndBookAndTransactionTypeOrderByIdDesc(Student student, Book book, TransactionType transactionType);

    Transaction findByTxnId(String txnId);

    // S1 --> B1 (Issuance) t1
    // s1 --> b1 (return) t2
    // s1 --> b1 (issue) t3
    // s1 --> b1 (return) t4
}
