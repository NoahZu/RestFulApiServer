package io.github.noahzu.controller;

import io.github.noahzu.core.HttpRequest;

public abstract class RequestBaseFilter {
	abstract HttpRequest onFilter(HttpRequest request);
}
