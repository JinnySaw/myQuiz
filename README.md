Copy from https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/

@Entity
All your domain models must be annotated with @Entity annotation.
It is used to mark the class as a persistent Java class.

@Table annotation is used to provide the detail of the table does this entity will be mapped to.
@Id annotation is used to define the primary key.
@GeneratedValue annotation is used to define the primary key generation strategy. In the above case, we have declared the primary key to be an Auto Increment field.

@NotBlank annotation is used to validate that the annotated field is not null or empty.

@Column annotation is used to define the properties of the column that will be mapped to the annotated field. You can define several properties like name, length, nullable, updateable etc.

@Temporal annotation is used with java.util.Date and java.util.Calendar classes. It converts the date and time values from Java Object to compatible database type and vice versa.

@JsonIgnoreProperties annotation is a Jackson annotation. Spring Boot uses Jackson for Serializing and Deserializing Java objects to and from JSON.

Enable JPA Auditing
In our model class we have annotated createdAt and updatedAt fields with @CreatedDate and @LastModifiedDate annotations respectively.

Now, what we want is that these fields should automatically get populated whenever we create or update an entity.

To achieve this, we need to do two things -

1. Add Spring Data JPA’s AuditingEntityListener to the domain model.

We have already done this in our model class with the annotation @EntityListeners(AuditingEntityListener.class).
@RestController annotation is a combination of Spring’s @Controller and @ResponseBody annotations.
@RestController annotation is a combination of Spring’s @Controller and @ResponseBody annotations.

The @Controller annotation is used to define a controller and the @ResponseBody annotation is used to indicate that the return value of a method should be used as the response body of the request.

@RequestMapping("/api") declares that the url for all the apis in this controller will start with /api.