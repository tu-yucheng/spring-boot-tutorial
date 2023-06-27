package cn.tuyucheng.taketoday.ejbspringcomparison.ejb.stateful;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ShoppingCartEJBRemote {

   void addItem(String item);

   List<String> getItems();

   String getName();

   void setName(String name);
}
