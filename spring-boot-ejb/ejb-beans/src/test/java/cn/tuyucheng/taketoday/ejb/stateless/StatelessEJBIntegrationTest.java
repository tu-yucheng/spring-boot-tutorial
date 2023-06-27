package cn.tuyucheng.taketoday.ejb.stateless;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;


@RunWith(Arquillian.class)
@Ignore("Will be fixed in BAEL-4422")
public class StatelessEJBIntegrationTest {

   @Inject
   private EJBClient1 ejbClient1;

   @Inject
   private EJBClient2 ejbClient2;

   @Deployment
   public static JavaArchive createDeployment() {
      return ShrinkWrap.create(JavaArchive.class)
            .addClass(StatelessEJB.class)
            .addClass(EJBClient1.class)
            .addClass(EJBClient2.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
   }

   @Test
   public void givenOneStatelessBean_whenStateIsSetInOneBean_secondBeanShouldHaveSameState() {

      // act
      ejbClient1.statelessEJB.name = "Client 1";

      // assert
      Assert.assertEquals("Client 1", ejbClient1.statelessEJB.name);
      Assert.assertEquals("Client 1", ejbClient2.statelessEJB.name);

   }

   @Test
   public void givenOneStatelessBean_whenStateIsSetInBothBeans_secondBeanShouldHaveSecondBeanState() {

      // act
      ejbClient1.statelessEJB.name = "Client 1";
      ejbClient2.statelessEJB.name = "Client 2";

      // assert
      Assert.assertEquals("Client 2", ejbClient2.statelessEJB.name);

   }
}