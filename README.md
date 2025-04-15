# 📚 Spring MVC 웹 애플리케이션

도서, 회원, 대여 기능을 포함한 Java 기반 Spring MVC 웹 애플리케이션.

계층 구조를 명확하게 나누었고, MyBatis와 JSP View를 사용한 전통적인 MVC 구조입니다.


---

## 🚀 Features

- 도서 목록 조회 및 등록
- 회원 가입 및 로그인
- 도서 대여 기능
- RESTful API와 JSP 기반 웹 인터페이스 제공
- 공통 예외 처리 및 응답 포맷 일관화

---

## 🛠 Environment & Dependencies

| Component | Version |
|-----------|--------|
| Java | Oracle OpenJDK 21 |
| Apache Tomcat | 10.1.39 |
| Spring MVC | 6.2.3 |
| MyBatis | 3.5.16 |
| MyBatis-Spring | 3.0.4 |
| Lombok | 1.18.36 |
| Hibernate Validator | 8.0.2.Final |
| Jackson (Core & Databind) | 2.15.3 |
| HikariCP | 5.1.0 |
| Logback | 1.5.16 |
| SLF4J | 2.0.16 |
| JSP JSTL | 3.0.1 / 3.0.2 |
| Servlet API | 6.0.0 |
| AspectJ | 1.9.22.1 |
| EL | 4.0.2 |
| MySQL Connector/J | 9.2.0 |

### 🧪 Test

| Library | Version |
|------------|--------|
| JUnit Jupiter | 5.11.4 |
| Spring Test | 6.2.3 |
| AssertJ | 3.26.3 |
| Mockito Core | 5.17.0 |
| Mockito JUnit Jupiter | 5.17.0 |

---

## 📂 Directory Structure (abstract)

```
/src
├── main
│   ├── java/com.grepp.spring
│   │   ├── app
│   │   │   ├── controller (api, web)
│   │   │   ├── model (book, member, rent)
│   │   │   └── infra (config, error, response, util)
│   │   └── IndexController.java
│   ├── resources
│   │   ├── init/*.sql
│   │   ├── mybatis/mappers/*.xml
│   │   ├── application.properties
│   │   └── logback.xml
│   └── webapp
│       ├── assets
│       ├── WEB-INF/spring
│       └── view (JSPs for book, member, etc.)
└── test
```

---
