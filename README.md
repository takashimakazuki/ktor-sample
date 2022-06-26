## Ktor サンプルアプリケーション

TODO管理webアプリケーションのバックエンドAPIです．

## tools
- ktor
- jdbi
- jackson

## note
- DBのパスワード等をコードに直書きしているため，本番環境では使用しない．

## memo

- build.gradle.ktl内の依存パッケージのバージョン指定をどのように書くべき？
  - プロジェクト作成時に自動生成された部分では，`$kotlin_version`等の変数を使ってバージョン指定を行なっている．jdbiの追加行でも同じように指定するべきかも
  - → gradle.propertiesというファイルにバージョン番号だけ別に書いている様子だった．なるほど．
- IDEのideaがすごい．
  - パッケージのバージョンが最新でない場合，以下のように教えてくれる．
  - `Package 'org.postgresql:postgresql' can be upgraded to version '42.3.6' `
- しかしidea結構動作が重い．RAM8GBではダメかも．なんとか軽くする方法を探す必要あり．
- Gradleよくわかっていないため要調査．パッケージ管理してくれるものか？
  - → （もともとは）Javaのビルドツールで，JavaファイルをJarファイルにビルドするもの
  - このプロジェクトでは`Gradle Kotlin DSL`を使用しており，GradleのビルドスクリプトをKotlinでかける．
  - → ビルドを行なっているタスクはどのファイルを見ればわかるのか？？

## reference
- https://qiita.com/tokio_k_/items/1bf9bfe8022f7031b029
- https://qiita.com/toliner/items/8b1ed6ed3cc04c22d63d
