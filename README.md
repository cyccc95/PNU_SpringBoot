# PNU_SpringBoot
[K-Digital 부산대22-1기] AI 활용 빅데이터분석 풀스택웹서비스 SW 개발자 양성과정

### Mission1
+ list 데이터를 생성해서 요청하는 정보를 제공
+ 구조 : Controller - Service
+ list 데이터는 Service에서 생성해서 가지고 있다가 요청에 따른 데이터를 제공

### Mission2
+ H2 Database에 저장된 데이터를 제공
+ Mission1과 비교해서 DAO 계층 추가
+ 구조 : Controller - Service -DAO

### Mission3
+ Mission1과 Mission2를 통합
+ Mission1의 MemberService에서 list 데이터를 제공하던 것을 MemberDAO 구현체인 MemberDAOList를 만들어서 정보를 제공
+ Mission2의 MemberDAO를 MemberDAOH2로 변경하고 MemberDAOH2에서 MemberDAO로 인터페이스 추출
+ Log를 남기는 기능을 가지는 LogDAO 추가
+ 인터페이스 LogInterface와 DB 저장 구현체 LogDAO로 구성

### Mission4
+ Mission3에서 어노테이션을 이용해서 의존성 주입이 되도록 수정

### Mission5
+ 파일 저장 구현체 LogDAOFileImpl 추가
+ Mission4에서 JDBC Connection을 만들어서 사용하는 방식을 JDBCTemplate을 이용하는 방식으로 변경
