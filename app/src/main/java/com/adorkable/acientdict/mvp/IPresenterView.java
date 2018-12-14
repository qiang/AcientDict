/*
 * Copyright (c) 2015 [1076559197@qq.com | tchen0707@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.adorkable.acientdict.mvp;

/**
 * Author: liuqiang
 * Time: 2018-12-14 10:33
 * Description:  多了一个设置  Presenter 的方法
 * google 的example 使用的这种方式， https://github.com/googlesamples/android-architecture/blob/todo-mvp/todoapp/app/src/main/java/com/example/android/architecture/blueprints/todoapp/taskdetail/TaskDetailPresenter.java
 * <p>
 * 这种方式的  Presenter 创建的地方不在 对应的View的实现类里面。
 * <p>
 * 而是在View的实现类上层，比如Fragment实现了View，但是Presenter的创作在Activity里面。
 */
@Deprecated
public interface IPresenterView<T> extends IView {

    void setPresenter(T presenter);
}
