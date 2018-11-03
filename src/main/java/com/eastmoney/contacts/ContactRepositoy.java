package com.eastmoney.contacts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepositoy extends JpaRepository<Contact, Integer> {
}
