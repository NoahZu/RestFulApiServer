package io.github.noahzu.controller;

import io.github.noahzu.core.HttpRequest;

public abstract class RequestBaseFilter {
	/**
	 * 为
	 * @param request
	 * @return true代表拦截了这个请求，请求处理器就不会收到该请求，false 代表没有拦截这个请求，请求会传给具体的请求处理器
	 */
	abstract boolean onFilter(HttpRequest request);
}
