# DB設計書(2022/09/05作成)

### 1.改版履歴
|版|作成者|作成日|概要|
|:--|:--|:--|:--|
|初版|鈴木健吾|2022/06/23|DB設計書の第1回を作成|  
|2版|鈴木健吾|2022/07/04|DB設計書の第2回を作成|
|3版|鈴木健吾|2022/09/05|DB設計書の第3回を作成|
  
#### 1-1第2版修正箇所
- varcharやintegerの先頭文字を小文字に変更
- passwordの制限文字数をハッシュ化後の64文字に変更  
- varcharの後に文字数制限を追加  

#### 1-2第3版修正箇所
- Rankingテーブルの削除
- ReadingRecordテーブルのprivateクラスが予約語だったため、privacyに変更し、booleanではなく、String型に変更



### DBの説明  
#### userテーブル  
|クラス名|型|制限|
|:--|:--|:--|
|name|varchar(20)|1文字以上20文字以内|
|sex|varchar(2)|2文字|
|age|integer|負の値不可能|
|password|varchar(64)|固定文字数(64文字)|
|id|integer|重複禁止,autoincrement|  
注意:全てnot nullである。

#### Readingrecordテーブル  
|クラス名|型|制限|
|:--|:--|:--|
|janru|varchar(20)|1文字以上20文字以内|
|privacy|varchar(10)|1文字以上10文字以内|
|thinking|varchar(200)|1文字以上200文字以内|
|isbn|varchar(20)|1文字以上20文字以内|
|title|varchar(100)|1文字以上100文字以内|
|review|integer|1以上5以下の値|  





### 3.クラス図URL  
https://github.com/HazeyamaLab/SpringWork2022G2/blob/G2/class/docs/class.md

### 3.画面シナリオURL  
https://www.figma.com/file/3abTVeNyTZf4VsoMkmczUq/G2%2F%E7%94%BB%E9%9D%A2%E3%82%B7%E3%83%8A%E3%83%AA%E3%82%AA?node-id=0%3A1
　
    
### 4.要求仕様書URL  
https://github.com/HazeyamaLab/SpringWork2022G2/blob/kengo/youkyuuteigi/docs/youkyuuteigi.md