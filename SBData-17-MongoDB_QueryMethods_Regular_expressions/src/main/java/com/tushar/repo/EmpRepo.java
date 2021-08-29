package com.tushar.repo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tushar.document.Employee;

public interface EmpRepo extends MongoRepository<Employee, String> {

	@Query( value="{eno:?0}")
	public Employee queryByEnoEquals(int eno);

	@Query(value="{salary: {$gt:?0, $lt :?1}}")
	public List<Employee> queryBySalaryBetween(double min, double max);

	@Query(value="{salary:{$lte:?0}}")
	public List<Employee> queryBySalaryLessThanEqual(double sal);
	
	@Query(value="{salary:{$gte:?0}}")
	public List<Employee> queryBySalaryGreaterThanEqual(double sal);
	
	@Query(value="{addrs:{$in:?0}}")
	public List<Employee> queryByAddrsIn(String...strings);

	@Query( value="{name:?0}")
	public List<Employee> queryByNameEquals(String name);
	
	@Query(value="{salary:{$gte:?0,$lte:?1}}")
	public List<Employee> queryBySalaryGreaterThanEqualsAndSalaryLessThanEquals(double min, double max);
	
	@Query( value="{name: {$regex:?0}}")
	public List<Employee> queryByNameRegExpression(String data);
	
	@Query(value="{salary: {$gt:?0, $lt :?1}}", count = true)
	public int queryCountBySalaryBetween(double min, double max);
	
	@Query( value="{eno:?0}", delete =true )
	public int queryDeleteByEnoEquals(int eno);

}
/*
GreaterThan					findByAgeGreaterThan(int age)								{"age" : {"$gt" : age}}
LessThan							findByAgeLessThan(int age)										{"age" : {"$lt" : age}}
Between							findByAgeBetween(int from, int to)						{"age" : {"$gt" : from, "$lt" : to}}
IsNotNull, NotNull		findByFirstnameNotNull()											{"age" : {"$ne" : null}}
IsNull, Null						findByFirstnameNull()												{"age" : null}
Like										findByFirstnameLike(String name)							{"age" : age} ( age as regex)
Regex								findByFirstnameRegex(String firstname)			{"firstname" : {"$regex" : firstname }}
(No keyword)					findByFirstname(String name)									{"age" : name}
Not										findByFirstnameNot(String name)							{"age" : {"$ne" : name}}
Near									findByLocationNear(Point point)							{"location" : {"$near" : [x,y]}}
Within								findByLocationWithin(Circle circle)						{"location" : {"$within" : {"$center" : [ [x, y], distance]}}}
Within								findByLocationWithin(Box box)								{"location" : {"$within" : {"$box" : [ [x1, y1], x2, y2]}}}True
IsTrue, True						findByActiveIsTrue()													{"active" : true}
IsFalse, False					findByActiveIsFalse()													{"active" : false}
Exists									findByLocationExists(boolean exists)					{"location" : {"$exists" : exists }}
*/