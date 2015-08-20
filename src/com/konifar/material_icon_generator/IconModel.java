package com.konifar.material_icon_generator;

import com.intellij.openapi.project.Project;

import java.io.File;

/*
 * Copyright 2014-2015 Material Design Icon Generator (Yusuke Konishi)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class IconModel {

    private static final String PATH_ICONS = "icons";
    private static final String PATH_DRAWABLE_PREFIX = "drawable-";
    private static final String UNDERBAR = "_";
    private static final String PNG_SUFFIX = ".png";
    private static final String WHITE = "white";

    private String iconName;
    private String displayColorName;
    private String colorCode;
    private String dp;
    private String fileName;
    private String resDir;

    private boolean mdpi;
    private boolean hdpi;
    private boolean xhdpi;
    private boolean xxhdpi;
    private boolean xxxhdpi;

    public IconModel(String iconName,
                     String displayColorName,
                     String colorCode,
                     String dp,
                     String fileName,
                     String resDir,
                     boolean mdpi,
                     boolean hdpi,
                     boolean xhdpi,
                     boolean xxhdpi,
                     boolean xxxhdpi) {
        this.iconName = iconName;
        this.displayColorName = displayColorName;
        this.colorCode = colorCode;
        this.dp = dp;
        this.fileName = fileName;
        this.resDir = resDir;
        this.mdpi = mdpi;
        this.hdpi = hdpi;
        this.xhdpi = xhdpi;
        this.xxhdpi = xxhdpi;
        this.xxxhdpi = xxxhdpi;
    }

    public String getLocalPath(String size) {
        if (iconName != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_ICONS);

            String[] fileString = iconName.split("/");
            sb.append(getLocalDrawabaleIconPath(getIconName(fileString[1]), size));

            return sb.toString();
        } else {
            return "";
        }
    }

    private String getLocalDrawabaleIconPath(String fileName, String size) {
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        String[] fileString = iconName.split("/");
        sb.append(fileString[0]);
        sb.append("/");
        sb.append(PATH_DRAWABLE_PREFIX);
        sb.append(size);
        sb.append("/");
        sb.append(fileName);
        return sb.toString();
    }

    private String getIconName(String shortName) {
        return getIconName(shortName, WHITE);
    }

    private String getIconName(String shortName, String colorName) {
        StringBuilder sb = new StringBuilder();
        sb.append(shortName);
        sb.append(UNDERBAR);
        sb.append(colorName);
        sb.append(UNDERBAR);
        sb.append(dp);
        sb.append(PNG_SUFFIX);
        return sb.toString();
    }

    public String getResourcePath(Project project) {
        return resDir;
    }

    public String getCopyPath(Project project, String size) {
        StringBuilder sb = new StringBuilder();
        sb.append(getResourcePath(project));
        sb.append(File.separator);
        sb.append(PATH_DRAWABLE_PREFIX);
        sb.append(size);
        sb.append(File.separator);
        sb.append(fileName);

        return sb.toString();
    }

    public void setIconAndFileName(String iconName) {
        if (iconName == null) {
            this.iconName = "";
            this.fileName = "";
        } else {
            this.iconName = iconName;
            String[] fileString = this.iconName.split("/");
            if (fileString.length > 1) this.fileName = getIconName(fileString[1], displayColorName);
        }
    }

    public void setDpAndFileName(String dp) {
        this.dp = dp;
        String[] fileString = iconName.split("/");
        if (fileString.length > 1) this.fileName = getIconName(fileString[1], displayColorName);
    }

    public void setDisplayColorName(String displayColorName) {
        this.displayColorName = displayColorName;
        String[] fileString = iconName.split("/");
        if (fileString.length > 1) this.fileName = getIconName(fileString[1], displayColorName);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setResDir(String resDir) {
        this.resDir = resDir;
    }

    public void setMdpi(boolean mdpi) {
        this.mdpi = mdpi;
    }

    public void setHdpi(boolean hdpi) {
        this.hdpi = hdpi;
    }

    public void setXhdpi(boolean xhdpi) {
        this.xhdpi = xhdpi;
    }

    public void setXxhdpi(boolean xxhdpi) {
        this.xxhdpi = xxhdpi;
    }

    public void setXxxhdpi(boolean xxxhdpi) {
        this.xxxhdpi = xxxhdpi;
    }

    public boolean isMdpi() {
        return mdpi;
    }

    public boolean isHdpi() {
        return hdpi;
    }

    public boolean isXhdpi() {
        return xhdpi;
    }

    public boolean isXxhdpi() {
        return xxhdpi;
    }

    public boolean isXxxhdpi() {
        return xxxhdpi;
    }

    public String getFileName() {
        return fileName;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

}
