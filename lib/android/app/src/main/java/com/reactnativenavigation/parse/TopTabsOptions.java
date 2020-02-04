package com.reactnativenavigation.parse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.reactnativenavigation.parse.params.Bool;
import com.reactnativenavigation.parse.params.Colour;
import com.reactnativenavigation.parse.params.NullBool;
import com.reactnativenavigation.parse.params.NullColor;
import com.reactnativenavigation.parse.params.NullNumber;
import com.reactnativenavigation.parse.params.Number;
import com.reactnativenavigation.parse.parsers.BoolParser;
import com.reactnativenavigation.parse.parsers.ColorParser;
import com.reactnativenavigation.parse.parsers.NumberParser;

import org.json.JSONObject;

public class TopTabsOptions {

    @NonNull public Colour selectedTabColor = new NullColor();
    @NonNull public Colour unselectedTabColor = new NullColor();
    @NonNull public Number fontSize = new NullNumber();
    @NonNull public Bool visible = new NullBool();
    @NonNull public Number height = new NullNumber();
    @NonNull public Colour rippleColor = new NullColor();
    @NonNull public Colour indicatorColor = new NullColor();
    @NonNull public Number indicatorHeight = new NullNumber();

    public static TopTabsOptions parse(@Nullable JSONObject json) {
        TopTabsOptions result = new TopTabsOptions();
        if (json == null) return result;
        result.selectedTabColor = ColorParser.parse(json, "selectedTabColor");
        result.unselectedTabColor = ColorParser.parse(json, "unselectedTabColor");
        result.fontSize = NumberParser.parse(json, "fontSize");
        result.visible = BoolParser.parse(json, "visible");
        result.height = NumberParser.parse(json, "height");
        result.rippleColor = ColorParser.parse(json, "rippleColor");
        result.indicatorColor = ColorParser.parse(json, "indicatorColor");
        result.indicatorHeight = NumberParser.parse(json, "indicatorHeight");
        return result;
    }

    void mergeWith(TopTabsOptions other) {
        if (other.selectedTabColor.hasValue()) selectedTabColor = other.selectedTabColor;
        if (other.unselectedTabColor.hasValue()) unselectedTabColor = other.unselectedTabColor;
        if (other.fontSize.hasValue()) fontSize = other.fontSize;
        if (other.visible.hasValue()) visible = other.visible;
        if (other.height.hasValue()) height = other.height;
        if (other.rippleColor.hasValue()) rippleColor = other.rippleColor;
        if (other.indicatorColor.hasValue()) indicatorColor = other.indicatorColor;
        if (other.indicatorHeight.hasValue()) indicatorHeight = other.indicatorHeight;
    }

    void mergeWithDefault(TopTabsOptions defaultOptions) {
        if (!selectedTabColor.hasValue()) selectedTabColor = defaultOptions.selectedTabColor;
        if (!unselectedTabColor.hasValue()) unselectedTabColor = defaultOptions.unselectedTabColor;
        if (!fontSize.hasValue()) fontSize = defaultOptions.fontSize;
        if (!visible.hasValue()) visible = defaultOptions.visible;
        if (!height.hasValue()) height = defaultOptions.height;
        if (!rippleColor.hasValue()) rippleColor = defaultOptions.rippleColor;
        if (!indicatorColor.hasValue()) indicatorColor = defaultOptions.indicatorColor;
        if (!indicatorHeight.hasValue()) indicatorHeight = defaultOptions.indicatorHeight;
    }
}
