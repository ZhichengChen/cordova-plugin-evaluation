#cordova-plugin-evaluation
Cordova call market to evaluation the App.

Base on [http://blog.csdn.net/wangfayinn/article/details/10351655](http://blog.csdn.net/wangfayinn/article/details/10351655)

#Installation
    cordova plugin add https://github.com/ZhichengChen/cordova-plugin-evaluation

#Usage

    navigator.evaluation.run(succesCallback, errorCallback)

* **succesCallback**: Callback to invoke when home is success. (*Function*)
* **errorCallback**: Callback to invoke when error occor. (*Function*)



#Example

    navigator.evaluation.run(function(){
        console.info("Successfully call");
    }, function(){
        console.error("Error call");
    });

#Support Platforms
* Android
