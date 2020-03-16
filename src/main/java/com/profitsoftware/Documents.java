package com.profitsoftware;

import java.util.ArrayList;


public class Documents extends ArrayList<Document>
{
  public Documents()
  {
    add(new Document("1", "Ilkka Salmenius",   "ABC", null,          "010101-XXXX", null));
    add(new Document("2", "Yritys Oy",         "ZZZ", "55-20002954", null,          "3-1234567"));
    add(new Document("3", "Teppo Testaaja",    "XYZ", "55-20002954", "010301-XXXX", null));
    add(new Document("3", "Matti Meikäläinen", "KLM", "55-20002954", "010301-1111", null));
    add(new Document("2", "Antti Laurila",     "123", "55-20002954", "010201-XXXX", null));
  }
}
