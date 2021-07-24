# ReservationProject

병원 예약 REST API 백엔드 프로젝트입니다.



## 프로젝트 개발 환경
```
IDE : STS 4
JAVA : openjdk 1.8
DB : H2
Mybatis : spring-boot-starter:2.2.0
SWAAGER : SWAAGER2
lombok
```

## 프로젝트 구조

프로젝트 구조입니다.

![image](https://user-images.githubusercontent.com/60130985/125964933-e60b2322-c9ac-4b76-a6ba-bf271cc29beb.png)

## API

데이터 삭제 API는 삭제 여부 컬럼을 두어 Y, N으로 관리하였습니다.

미완성 목록
1. 예약 등록
2. 달력 테이블을 생성하여 batch job 을 이용해 천문 연구원 API 통신을 통한 명절 여부를 관리하려했지만 개발 중 입니다.
3. REST API 통신 message를 위한 Message class Service 단으로 옮기기


|Method|URL|설명|비고|
|--------------------|--------------------|-------------------|-------------------|
|Get|/reservation/get/{day}|병원 전체 예약 조회|완료|
|Get|/reservation/doctor/{docId}/schedule/{date}|의사 스케줄 조회|완료|
|Post|/reservation|예약 등록|미완성, 진척률 10%|
|Delete|/reservation/get/{day}|예약 삭제|완료|
|Post|/doctor|의사 등록|완료|
|Put|/doctor/{id}|의사 수정|완료|
|Delete|/doctor/{id}|의사 삭제|완료|
|Post|/holiday|휴무일 등록|완료|
|Put|/holiday|휴무일 삭제|완료|

## TEST

테스트는 Postman을 사용하였습니다.
테스트 데이터는 서버 실행 시 H2 DB에 insert 되고 있습니다. 

reservation-project\src\main\resources\h2\schema.sql - table 생성 쿼리 파일의 위치 입니다.

reservation-project\src\main\resources\h2\data.sql - insert 쿼리 파일의 위치 입니다.

```
http://localhost:8080/swagger-ui.html#/  SWAGGER 연동을 하였지만 많은 수정이 필요한 상태입니다.

DELETE http://localhost:8080/doctor/6 의사 삭제에 대한 테스트 예시 입니다.

GET http://localhost:8080/reservation/doctor/4/schedule/20210723  의사 스케줄 조회에 대한 테스트 예시 입니다.

POST http://localhost:8080/holiday 휴무일 추가에 대한 테스트 예시 입니다.
     {
      "docId" : 2
      ,"holiDt" : "2021-07-26"
      ,"delYn" : "N"
    }
```

## DB ERD
예약 프로젝트의 DB ERD 설계입니다.

달력 테이블을 생성하여 spring batch를 사용하여 한국 천문 연구원 API 통신을 통한 명절 당일 여부를 관리를 의도했습니다.

진료 시간 테이블을 생성하여 예약 등록 시 달력 테이블을 조회하며 진료 예약 가능 시간을 관리를 의도했습니다.

![image](https://user-images.githubusercontent.com/60130985/125962715-8f2fca88-7158-43b9-9bce-dfc04a1743d6.png)


