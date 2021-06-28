package ro.ubb.sensors.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sensor.class)
public abstract class Sensor_ extends ro.ubb.sensors.model.BaseEntity_ {

	public static volatile SingularAttribute<Sensor, String> name;
	public static volatile SingularAttribute<Sensor, Long> time;
	public static volatile SingularAttribute<Sensor, Integer> measurement;

	public static final String NAME = "name";
	public static final String TIME = "time";
	public static final String MEASUREMENT = "measurement";

}

