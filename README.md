# MC_Spigot_PlgIn
## MCPlugIn119v한정.
### MC_Config작성법
;아래의 것들을 그대로 복사해서쓴다.</br>
;파일 위치는 자신의 마인크 "최상위 디랙터리"다.</br>
;그 이외의 위치에선 인식하지 않는다.</br>
;</br>
;필요하다면 ;로 가두고, 아니면 지워라.</br>
;모든 명령줄은 &로 시작하고, =를 통해 구분한다.</br>
;띄어쓰기도 인식한다. 다만 새줄은 인식하지 않는다.</br>
;줄바꿈은 ```</br>```을 통해서만 가능하다.</br>
;만약 아래 사항중 하나라도 누락되게 된다면, 애러 뿜고 플러그인 동작 안한다!</br>
;</br>
;SQLServer</br>
;자신의 데이터 베이스 정보를 입력하는 곳이다.</br>
&ServerAdress=</br>
;자신의 데이터베이스 서버를 가리킨다.</br>
;IP도 좋고 도메인 주소도 좋다.</br>
;</br>
&UserName=당신의 데이터 베이스 계정이름이다.</br>
&Password=해당 계정의 비밀번호이다.</br>
;</br>
;Twitter</br>
;트위터와 연동을 하기위한 각종 정보를 넣는 곳이다.</br>
;아래 두개는 Authentication Tokens밑에 있는 키들을 말한다.</br>
&AccessToken=당신의 Access Token을 말한다.</br>
&AccessToken_Secret=Access Secret을 말한다.</br>
;</br>
;Consumer Keys를 말한다.</br>
&ComsumeAPIKey=API Key를 말한다.</br>
&ComsumeAPI_Secret=APISecret을 말한다.</br>
;</br>
&ServerOpenMSG=서버가 시작했을때 사용되는 명령어다.</br>
&ServerCloseMSG=서버가 꺼질때 사용 되는 명령어다.</br>
;</br>
&PlayerDataFile=</br>
;당신의 유저 데이터 파일이 몰려있는 곳을 말한다.</br>
;무조건 절대 경로로 적을것.</br>
