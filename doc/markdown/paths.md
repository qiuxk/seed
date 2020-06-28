
<a name="paths"></a>
## Paths

<a name="getusingget"></a>
### get
```
GET /test/get
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* test-controller


<a name="get2usingget"></a>
### get2
```
GET /test/get2
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* test-controller


<a name="get3usingget"></a>
### 测试封装返回值
```
GET /test/get3
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**0**|返回成功 ：<br>001 ,系统异常|No Content|
|**200**|OK|[CommonResult](#commonresult)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* test-controller



