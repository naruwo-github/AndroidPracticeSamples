### Android始めました
このリポジトリは、入門したての練習ファイルをストックするところです。
それぞれのアプリに昨日と説明をまとめていき、備忘録程度で扱えたらいいなと思ってます。

#### Androidのアクティビティ
アクティビティは、Androidの「１つの画面」に対応するもの。アクティビティには、ビューの配置(ボタンや画像、テキストなど)やイベントの処理(キー操作や画面タッチ、ボタンクリックなど)などを書いていく。

### アクティビティとライフサイクル
アクティビティの状態は、大きく分けると４つ
・開始
・終了
・再開
・強制終了

##### アクティビティの開始時
|  アクティビティ開始  |
| ↓ |
|  onCreate()  |
| ↓ |
|  onStart()  |
| ↓ |
|  onResume()  |
| ↓ |
|  アクティビティ実行中  |

画面が表示される時、onCreateメソッドが呼ばれる。ここに何か書いておけば、Activity実行時に勝手に実行されるてこと。画面の初期化処理などを記述するのが普通。
そのあと、onStartメソッド、onResumeメソッドが呼ばれ、画面が表示される。

##### アクティビティの終了時
|  アクティビティ実行中  |
| ↓(別のActivityが最前面になる) |
|  onPause()  |
| ↓(アクティビティが非表示になる) |
|  onStop()  |
| ↓ |
|  onDestroy()  |
| ↓ |
|  アクティビティ終了  |



##### アクティビティの再開時

##### アクティビティの強制終了時
