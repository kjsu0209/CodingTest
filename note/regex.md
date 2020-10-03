## regex 패턴 모음집
#### [정규식 테스트 사이트](https://regexr.com/)
---

### 두번 반복되는 알파벳
```
p = r'(.)\1{1}'
```

### 알파벳 단어 첫글자를 대문자로
```
pattern = r'( [a-z])'
toUppder = lambda pat: ' ' + pat.group(0)[1].upper()
answer = re.sub(pattern, toUppder, s)
```
