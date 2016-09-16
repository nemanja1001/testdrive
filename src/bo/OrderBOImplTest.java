package bo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import bo.exception.BOException;
import dao.OrderDAO;
import dto.Order;

import static org.mockito.Mockito.*;

import java.sql.SQLException;

public class OrderBOImplTest {

	@Mock
	OrderDAO dao;
	private OrderBOImpl bo;
	
	@Before 
	public void setup(){
		MockitoAnnotations.initMocks(this);
		bo = new OrderBOImpl();
	}
	
	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
		
		bo.setDao(dao);
		
		Order order = new Order();
		
		when(dao.create(order)).thenReturn(new Integer(1));
		boolean result = bo.placeOrder(order);
		
		assertTrue(result);
		verify(dao).create(order);
	}
	
	@Test
	public void placeOrder_Should_Not_Create_An_Order() throws SQLException, BOException {
		
		bo.setDao(dao);
		
		Order order = new Order();
		
		when(dao.create(order)).thenReturn(new Integer(0));
		boolean result = bo.placeOrder(order);
		
		assertFalse(result);
		verify(dao).create(order);
	}
/*
	@SuppressWarnings({ "unchecked", "unused" })
	@Test(expected = BOException.class)
	public void placeOrder_Should_Throw_BOException() throws SQLException, BOException {
		
		Order order = new Order();
		
		when(dao.create(order)).thenThrow(SQLException.class);
		boolean result = bo.placeOrder(order);
	}
	*/
	@Test
	public void cancelOrder_Should_Cancel_The_Order() throws SQLException, BOException {
		
		Order order = new Order();
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(1);
		boolean result = bo.cancelOrder(123);
		
		assertTrue(result);
		verify(dao).read(123);
		verify(dao).update(order);
	}

	@Test
	public void cancelOrder_Should_Not_Cancel_The_Order() throws SQLException, BOException {
		
		Order order = new Order();
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(1);
		boolean result = bo.cancelOrder(123);
		
		assertFalse(result);
		
		verify(dao).read(123);
		verify(dao).update(order);
	}

}
