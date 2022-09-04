# クラス図(2022/06/19作成)

### 1.改版履歴
|版|作成者|作成日|概要|
|:--|:--|:--|:--|
|初版|鈴木健吾|2022/06/10|クラス図の第一回を作成|
|2版|鈴木健吾|2022/06/19|インスペクションの反映後、クラス図の第2回を作成|  
|3版|鈴木健吾|2022/06/29|インスペクションの反映後、クラス図の第3回を作成|  


第2版修正箇所  
- class.pngファイルの説明記載
- クラスの名称と型、制限についで明記
- Rankingクラスの関係性について再考慮  
-  関連を記載  
- パスワードをString型に直す
- private属性をBoolean型に修正　  
- 関係性について言語化

第3版修正箇所  
- Boolean型のTrueとFalseの状態で、それぞれ公開と非公開のどちらを取るのか明記
- sexクラスにおいて、入力されるのは女性と男性のみに制限。  

  

### ファイルの説明  
class.png
- クラス図の写真です。  

### クラスの説明  
#### userクラス  
|クラス名|型|制限|
|:--|:--|:--|
|name|String|0文字不可能|
|sex|String|男性か女性かの入力をする。|
|age|int|負の値不可能|
|Password|String|大文字小文字含む英数字含む6文字以上|
|id|int|重複禁止|  


#### Readingrecordクラス  
|クラス名|型|制限|
|:--|:--|:--|
|janru|String|0文字不可能|
|private|Boolean|Trueの時に公開、Falseの時に非公開|
|Thinking|String|0文字不可能|
|ISBN|String|0文字不可能|
|title|String|0文字不可能|
|review|int|1~5の値|  


#### Rankingクラス  
|クラス名|型|制限|
|:--|:--|:--|
|title|String|0文字不可能|
|review|int|1~5の値|
|rank|int|1~10の値|  





### 2.画面シナリオURL  
https://www.figma.com/file/3abTVeNyTZf4VsoMkmczUq/G2%2F%E7%94%BB%E9%9D%A2%E3%82%B7%E3%83%8A%E3%83%AA%E3%82%AA?node-id=0%3A1
　
    
### 3.要求仕様書URL  
https://github.com/HazeyamaLab/SpringWork2022G2/blob/kengo/youkyuuteigi/docs/youkyuuteigi.md