package com.test;
import javax.persistence.*;



@Entity
@Table(name="bank_tbl")
public class Bank {
    @Id
    @GeneratedValue	
    @Column(name="bank_id")
	private int bank_id = 0;
    
    @Column(name="bank_name")
	private String bank_name = "";
    
    @Column(name="account_name")
    private String account_name = "";
    
    @Column(name="account_date")
    private String account_date;    
    
    @Override
	public String toString() {
		return "Bank [bank_id=" + bank_id + ", bank_name=" + bank_name + ", account_name=" + account_name
				+ ", account_date=" + account_date + "]";
	}
	public int getBank_id() {
		return bank_id;
	}
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getAccount_date() {
		return account_date;
	}
	public void setAccount_date(String account_date) {
		this.account_date = account_date;
	}
}
