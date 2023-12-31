# 🚀 Level1

### 나의 생각

- 무기는 중복되는 메서드, 필드가 많으므로 상속을 잘 활용해서 중복 코드 줄이기
- 칼전사, 활전사를 나누지 않고 '전사'가 무기만 갈아끼우면 되도록
- 프로그램 내 캐릭터 인스턴스는 칼전사, 활전사, 불마법사, 얼음마법사 4개만 존재한다.
- 새로운 캐릭터 타입이 추가되면 switch문에 case를 추가해야 하는 문제점이 있는 것 같다.

### 문제 풀이

1. 캐릭터를 생성한다.
2. 전사의 기본 무기는 칼, 마법사의 기본 무기는 불지팡이이므로 다른 무기를 쓰고 싶다면 생성자 매개변수로 무기를 넣어준다.
3. setter 를 통해 무기는 언제든 갈아끼울 수 있다.
4. 캐릭터 type과 기본 공격력을 매개변수로 전달해서 출력문을 관리한다.


<br/>
<br/>
<br/>
<br/>

---

<br/>
<br/>
<br/>
<br/>

### 🎯 요구 사항

<aside>
3️⃣ 캐릭터는 무기를 교체할 수 있습니다.

- **조건: 캐릭터 클래스를 추상 클래스로 구현하고, 캐릭터 객체 생성은 캐릭터 공장 클래스에 의해 이루어져야 합니다.**
- 아래 코드가 작동하도록 Main 클래스 외에 나머지 부분을 코딩해주세요.
- `무기` 추상클래스를 구현해주세요.
- `칼`, `활`, `불지팡이`, `얼음지팡이` 클래스를 구현해주세요.
- `캐릭터`가 `무기`를 사용하는 `구성`으로 설계해주세요.
- 출력은 오직 `System.out.println` 함수만 이용해주세요.
- `System.out.println`은 오직 `무기` 클래스에서만 사용할 수 있습니다.
- `얼음마법사`는 초반 아이템이 `얼음지팡이`라는 점만 제외하면 나머지는 `마법사`와 같습니다.
- 각각의 캐릭터 객체는 2개이상 존재할 수 없습니다. 1개만 존재해야 합니다.
    - `캐릭터공장.get("활전사");` 코드를 2번 실행한다고 하더라도, 활전사 객체는 단 1명만 존재해야 합니다.
    - 캐릭터공장은 Map을 사용해서 한번 생성했던 객체들을 보관해야 합니다.
</aside>

### ✅ 입출력 예시

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        캐릭터 a캐릭터 = 캐릭터공장.get("칼전사");

        a캐릭터.공격();
        // 출력 : 전사(이)가 칼(으)로 공격합니다.
        // 출력 : 데미지 : 전사 기본공격력(10) * 칼 공격력(20) => 200

        a캐릭터 = 캐릭터공장.get("활전사");

        a캐릭터.공격();
        // 출력 : 전사(이)가 활(으)로 공격합니다.
        // 출력 : 데미지 : 전사 기본공격력(10) * 활 공격력(100) => 1000
        
        a캐릭터 = 캐릭터공장.get("불마법사");

        a캐릭터.공격();
        // 출력 : 마법사(이)가 불지팡이(으)로 공격합니다.
        // 출력 : 데미지 : 마법사 기본공격력(5) * 불지팡이 공격력(50) => 250
        
        a캐릭터 = 캐릭터공장.get("얼음마법사");

        a캐릭터.공격();
        // 출력 : 마법사(이)가 얼음지팡이(으)로 공격합니다.
        // 출력 : 데미지 : 마법사 기본공격력(5) * 얼음지팡이 공격력(60) => 300
    }
}
```