/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package examples.dao;


import java.util.List;

import examples.dto.Book;

import org.seasar.dao.annotation.tiger.*;

/**
 *Thao tác với bảng sách trong cơ sở dữ liệu  
 *@author Cao.Tan
 *@version 1.0	 
 */
@S2Dao(bean = Book.class)
public interface BookDao {



    public static final String ARGS_findByCategory = "category";

    public static final String findByCategoryPagerCondition_QUERY = "ORDER BY ID";
    
    public Book findByCode(int MaSach);
    
    public String findTypeBook(int MaSach);
    
   
    public void updateBook(int MaSach);
    
    public List getAllBook();

   

}