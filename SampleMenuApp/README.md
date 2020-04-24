## メニューアプリ
画面右上のメニューからランチ/ディナーのメニューを選択し、表示させることができます。

また、画面長押しで出るコンテキストメニューから様々な操作を行うことができます。
<img src="src/画面１.png" width="300px">  <img src="src/画面２.png" width="300px">

<img src="src/画面３.png" width="300px">  <img src="src/画面４.png" width="300px">


### HTMLや画像を準備する
WebViewでHTMLで作成した画面を表示させます。

HTMLコンテンツは大抵、HTMLファイル、画像、スクリプトやCSSなど多数のファイルとフォルダで構成されます。

このようなフォルダ階層を保持したまま利用したリソースはassetsフォルダにおきます。

##### app右クリック→new→folder→assets folder→finishで作成。



### ベクタ形式の画像を利用する
build.gradleのdefaultConfigセクションに
```
vectorDrawables.useSupportLibrary = true
```
を記述する。



### オプションメニューを使う
使う手順は主に３つ。①メニューXMLファイルを用意。②onCreateOptionsMenuメソッドで、用意したメニューXMLを指定。③onOptionsSelectedメソッドにメニューが選択された時の処理を追記。
##### resを右クリック→new→android resource fileでresource typeにmenuを選ぶ



### 暗黙インテントを使う
アクティビティを起動する時のインテントは、「明示的インテント」。起動したいクラスを指定しないで、起動したい機能だけ指定し、Androidシステムによって起動するアプリを判断させるインテントを、「暗黙的インテント」という。

##### デフォルトで定義済みのアクション(一部)
|定数名|意味|
|----|----|
|Intent.ACTION_CALL|電話をかける。|
|Intent.ACTION_VIEW|データを表示する。|
|Intent.ACTION_EDIT|データを編集する。|
|Intent.ACTION_SYNC|端末上のデータをサーバー上のデータと同期する。|
|Intent.ACTION_SEND|データを配信する。|
などなど。。。
