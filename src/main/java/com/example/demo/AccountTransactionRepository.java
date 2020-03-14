package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, CustomerIdentity> {

    @Query("select transactionNo,accountBalance from AccountTransaction  where accountId = :accId and " +
            " transactionNo = (select max(transactionNo) from AccountTransaction  where accountId = :accId)")
    public List findPreviousBalance(String accId);

    @Query("select DISTINCT CASE when :accId in (select DISTINCT accountId from AccountTransaction) " +
            "then 'False' " +
            "else 'True' " +
            "end as newAccount from AccountTransaction")
    public String checkIfNewAccount(String accId);

    @Query("select atr.transactionNo,atr.transactionDate, concat(u.firstName, u.middleName, u.lastName) as Name  ,atr.transactionAmount, atr.transactionType, atr.accountBalance from AccountTransaction atr " +
            "inner join BillPayee b on atr.payeeId = b.payeeId inner join User u on b.userId = u.userId where atr.accountId = :accId")
    public List getTransactionsForAccount(String accId);
}
