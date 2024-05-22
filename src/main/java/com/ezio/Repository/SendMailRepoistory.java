package com.ezio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezio.Model.SendByMail;



public interface SendMailRepoistory  extends JpaRepository<SendByMail, Long>{

}
