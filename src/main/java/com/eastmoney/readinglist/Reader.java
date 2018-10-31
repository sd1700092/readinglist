package com.eastmoney.readinglist;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Administrator
 * created: 2018-10-31 17:41
 */
@Entity
public class Reader {
    private static final long serialVersionUID = 1L;

    @Id
    private String username;
}
