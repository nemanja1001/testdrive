package dao;

import java.sql.SQLException;

import dto.Order;

public class OrderDAOOImpl implements OrderDAO {

	@Override
	public int create(Order order) throws SQLException {
		System.out.println("Inside OrderDAOImpl.create method");
		return 0;
	}

	@Override
	public Order read(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Order order) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
