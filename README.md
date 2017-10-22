##### RecyclerView에서 onClickListener 구현할 때 주의할 점

##### view를 띄워주는 public void onBindViewHolder(MyHolder holder, int position)에서 보여줄 경우
##### 함수가 안보이는 view까지 생성을 해주고 position은 그 곳으로 가게 된다.

##### 따라서 Holder에서 onclickListner 구현 후 넘겨줄 값을 onbindViewHolder에서 받아
##### Holder 안에 있는 값에 넣어준 후 onClickListner에 넣는다.

##### 지금 문제점은 AsyncTask의 onPostExecute()함수가 Fragment의 모든 생명주기 함수가 실행된 후 실행된다는 것이다.
##### 그 이유는 AsyncTask 자체의 걸리는 시간이 너무 오래 걸려서 Fragment의 생명주기 함수가 실행된 후 Async가 완료된다.
##### Fragment 띄워주는 것을 Thread.sleep()을 이용해 좀 늦추면 Async가 완료되고 Fragment 생명주기 함수 실행됨
##### 해결한 방법은 onPostExecute() 함수 내에 Fragment를 띄워주는 함수를 넣으면 된다.
