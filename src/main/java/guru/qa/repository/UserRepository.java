package guru.qa.repository;

import guru.qa.model.User;

import java.util.List;

public interface UserRepository {

  List<User> findAll() throws Exception;
}
