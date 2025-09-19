# 🛒 Simple Order

![Java](https://img.shields.io/badge/Java-17-blue?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![Status](https://img.shields.io/badge/status-in%20progress-yellow)

---

## 비즈니스 요구사항 & 설계

### 회원
- 회원은 **가입**하고 **조회**할 수 있다.  
- 회원 등급은 **일반**과 **VIP** 두 가지로 나뉜다.  
- 회원 데이터 저장소는  
  - 자체 **DB**를 구축할 수도 있고  
  - 외부 **시스템 연동**으로 대체할 수도 있다. (**미확정**)

---

### 주문 & 할인 정책
- 회원은 **상품을 주문**할 수 있다.  
- **회원 등급별 할인 정책**을 적용한다.  
- 현재 정책:  
  - **VIP 회원 → 1000원 정액 할인**  --> **정률할인**으로 바꾸고 싶다는 기획자 요청
- 향후 정책:  
  - 할인 정책은 **변경 가능성**이 크다.  
  - 오픈 직전까지도 정책이 바뀔 수 있다.  
  - 최악의 경우 **할인을 아예 적용하지 않을 수도 있음**. (**미확정**)  

---

## 도메인 협력 관계
<p align="center">
  <img width="512" src="https://github.com/user-attachments/assets/4ee25655-8e76-4463-a395-ef8831f90ba7" alt="도메인 협력 관계 다이어그램"/>
</p>


---

## 회원 클래스 및 회원 객체 다이어그램
<p align="center">
  <img width="515" src="https://github.com/user-attachments/assets/55da7c1a-2291-4b0a-afbd-1e7e2b4fb321" alt="회원 클래스 다이어그램"/>
</p>

---

