package com.example.resumemaker

import android.net.Uri
import android.os.Build
import android.os.Environment
import androidx.annotation.RequiresApi
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.educations.Education
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.hobbies.Hobby
import com.example.resumemaker.languages.Language
import com.example.resumemaker.objectives.Objective
import com.example.resumemaker.profile.BasicInfo
import com.example.resumemaker.projects.Project
import com.example.resumemaker.referances.Referance
import com.example.resumemaker.skills.Skill
import java.io.File

class GenerateResume(
    val basicInfo: BasicInfo,
    val objective: ArrayList<Objective>,
    val experiences: ArrayList<Experience>,
    val skills: ArrayList<Skill>,
    val educations: ArrayList<Education>,
    val projects: ArrayList<Project>,
    val achivements: ArrayList<Achivement>,
    val languages: ArrayList<Language>,
    val references: ArrayList<Referance>,
    val hobbies:ArrayList<Hobby>
) {
    var className:String=""
    fun template1():String{

        var htmlCode:String="<!DOCTYPE html >\n" +
                "<html>\n" +
                "<head>\n" +
                "\n" +
                "\t<title>Jonathan Doe | Web Designer, Director | name@yourdomain.com</title>\n" +
                "\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n" +
                "\n" +
                "\t<meta name=\"keywords\" content=\"\" />\n" +
                "\t<meta name=\"description\" content=\"\" />\n" +
                "\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/font.css\" media=\"all\" /> \n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/resume.css\" media=\"all\" />\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div id=\"doc2\" class=\"yui-t7\">\n" +
                "\t<div id=\"inner\">\n" +
                "\t\n" +
                "\t\t<div id=\"hd\">\n" +
                "\t\t\t<div class=\"yui-gc\">\n" +
                "\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t<h1>${basicInfo.name}</h1>\n" +
                "\t\t\t\t\t<h2>${basicInfo.designation}</h2>\n" +
                "                    <h3>${basicInfo.address}</h3>\n" +
                "\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t<div class=\"yui-u\">\n" +
                "\t\t\t\t\t<div class=\"contact-info\">\n" +
                "\t\t\t\t\t\t<h3>${basicInfo.gmail}</h3>\n" +
                "\t\t\t\t\t\t<h3>${basicInfo.phone}</h3>\n" +
                "                        <h3>${basicInfo.github}</h3>\n" +
                "                        <h3>${basicInfo.linkedin}</h3>\n" +
                "                        <h3>${basicInfo.dob}</h3>\n" +
                "\t\t\t\t\t</div><!--// .contact-info -->\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div><!--// .yui-gc -->\n" +
                "\t\t</div><!--// hd -->\n" +
                "\n" +
                "\t\t<div id=\"bd\">\n" +
                "\t\t\t<div id=\"yui-main\">\n" +
                "\t\t\t\t<div class=\"yui-b\">\n" +
                "\n" +
                "\t\t\t\t\t<div class=\"yui-gf\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Profile</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">\n" +
                "\t\t\t\t\t\t\t<p class=\"enlarge\">\n" +
                "\t\t\t\t\t\t\t\t${objective.get(0).data}\n" +
                "\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "\t\t\t\t\t<div class=\"yui-gf\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Skills</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">\n"

        for(i in skills){

            htmlCode=htmlCode+"<div class=\"talent\">\n" +
                    "\t\t\t\t\t\t\t\t\t<h3>${i.title}</h3>\n" +
                    "\t\t\t\t\t\t\t\t\t<p>${i.expLevel}\t</p>\n" +
                    "\t\t\t\t\t\t\t\t</div>"
        }

        htmlCode=htmlCode+"          \n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "\t\t\t\t\t\n" +
                "\n" +
                "\t\t\t\t\t<div class=\"yui-gf\">\n" +
                "\t\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Experience</h2>\n" +
                "\t\t\t\t\t\t</div><!--// .yui-u -->\n" +
                "\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">"
        var num:Int=experiences.size
        var n:Int=0
        for(i in experiences){
            if(++n==num){
                className="job last"
            }
            else{
                className="job"
            }
            htmlCode=htmlCode+"<div class=\"$className\">\n" +
                    "\t\t\t\t\t\t\t\t<h2>${i.company} (${i.city})</h2>\n" +
                    "\t\t\t\t\t\t\t\t<h3>${i.title}</h3>\n" +
                    "\t\t\t\t\t\t\t\t<h4>${i.startDate}-${i.EndDate}</h4>\n" +
                    "\t\t\t\t\t\t\t\t<p>${i.details}</p>\n" +
                    "\t\t\t\t\t\t\t</div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t</div><!--// .yui-u -->\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "\n" +
                "\t\t\t\t\t<div class=\"yui-gf\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Education</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">"

        var num2:Int=educations.size
        var n2:Int=0
        for (i in educations){
            if(++n2==num2){
                className="job last"
            }
            else{
                className="job"
            }
            htmlCode=htmlCode+"<div class=\"$className\">\n" +
                    "                                <h2>${i.school} (${i.city})</h2>\n" +
                    "                                <h4>${i.startDate}-${i.endDate}</h4>\n" +
                    "                                <h3>${i.degree}</h3>\n" +
                    "                                <p>${i.details}</p>\n" +
                    "                            </div>"
        }
        htmlCode=htmlCode+"</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "                    <div class=\"yui-gf\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Projects</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">"

        var num3:Int=projects.size
        var n3:Int=0
        for (i in projects){
            if(++n3==num3){
                className="job last"
            }
            else{
                className="job"
            }

            htmlCode=htmlCode+"<div class=\"$className\">\n" +
                    "                                <h2>${i.title}</h2>                \n" +
                    "                                <p>${i.details}</p>\n" +
                    "                            </div>"
        }

        htmlCode=htmlCode+"\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "                    <div class=\"yui-gf\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Achievements</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">"

        var num4:Int=achivements.size
        var n4:Int=0
        for (i in achivements){
            if(++n4==num4){
                className="job last"
            }
            else{
                className="job"
            }
            htmlCode=htmlCode+"<div class=\"$className\">\n" +
                    "                                <h2>${i.title}</h2>                \n" +
                    "                                <p>${i.details} </p>\n" +
                    "                            </div>"
        }

        htmlCode=htmlCode+"\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "                    <div class=\"yui-gf\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Languages</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">"

        var num5:Int=languages.size
        var n5:Int=0
        for (i in languages){
            if(++n5==num5){
                className="job last"
            }
            else{
                className="job"
            }
            htmlCode=htmlCode+"<div class=\"$className\">\n" +
                    "                                <h2>${i.lang}</h2>                \n" +
                    "                                <p>${i.expLevel}</p>\n" +
                    "                            </div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "                    <div class=\"yui-gf\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Hobbies</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">"

        var num9:Int=languages.size
        var n9:Int=0
        for (i in hobbies){
            if(++n9==num9){
                className="job last"
            }
            else{
                className="job"
            }
            htmlCode=htmlCode+"<div class=\"$className\">\n" +
                    "                                <h2>${i.title}</h2>                \n" +

                    "                            </div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "                    <div class=\"yui-gf last\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Referance</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">"
        var num6:Int=references.size
        var n6:Int=0
        for (i in references){
            if(++n6==num6){
                className="job last"
            }
            else{
                className="job"
            }
            htmlCode=htmlCode+"<div class=\"$className\">\n" +
                    "                                <h3>${i.personName}</h3> \n" +
                    "                                <h2>${i.companyName}</h2>\n" +
                    "                                \n" +
                    "                                <h3>${i.phone}</h3> \n" +
                    "                                <h3>${i.gmail}</h3>                \n" +
                    "                            </div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "\n" +
                "\t\t\t\t</div><!--// .yui-b -->\n" +
                "\t\t\t</div><!--// yui-main -->\n" +
                "\t\t</div><!--// bd -->\n" +
                "\n" +
                "\t\t\n" +
                "\t</div><!-- // inner -->\n" +
                "\n" +
                "\n" +
                "</div><!--// doc -->\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>\n"
        return htmlCode
    }

    fun template2():String{

        var htmlCode:String="<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\"/>\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<title>Cv Templet</title>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/styletemp2.css\" media=\"all\" />\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"Cv_Templet\">\n" +
                "\t<svg class=\"Path_15\" viewBox=\"0 0 780.276 1551.987\">\n" +
                "\t\t<path id=\"Path_15\" d=\"M 0 0 L 772.7133178710938 0 L 780.275634765625 0 L 780.275634765625 1551.986694335938 L 0 1551.986694335938 L 0 0 Z\">\n" +
                "\t\t</path>\n" +
                "\t</svg>\n" +
                "\t\n" +
                "\t<svg class=\"Path_16\" viewBox=\"1410.669 488.638 46.136 99.447\">\n" +
                "\t\t<path id=\"Path_16\" d=\"M 1456.805419921875 488.6380004882812 C 1431.008178710938 490.5535278320312 1410.6689453125 512.0751342773438 1410.6689453125 538.3615112304688 C 1410.6689453125 564.6478881835938 1431.008178710938 586.1694946289062 1456.805419921875 588.0850830078125 L 1456.805419921875 488.6380004882812 Z\">\n" +
                "\t\t</path>\n" +
                "\t</svg>\n" +
                "\t<div id=\"Group_22\">\n" +
                "\t\t<svg class=\"Path_17\" viewBox=\"962 534 130.663 130.423\">\n" +
                "\t\t\t<path id=\"Path_17\" d=\"M 1092.662475585938 538.4828491210938 C 1092.662475585938 536.979736328125 1092.601806640625 535.4913330078125 1092.5498046875 534 L 961.9998779296875 534 L 961.9998779296875 664.3026733398438 C 963.5697021484375 664.3619995117188 965.1395263671875 664.422607421875 966.722900390625 664.422607421875 C 1036.27783203125 664.422607421875 1092.662475585938 608.0377807617188 1092.662475585938 538.4828491210938 Z\">\n" +
                "\t\t\t</path>\n" +
                "\t\t</svg>\n" +
                "\t</div>\n" +
                "\t<div id=\"Pic\">\n" +
                "\t\t<div id=\"Group_3\">\n" +
                "\t\t\t<div id=\"Group_2\">\n" +
                "\t\t\t\t<img id=\"Group_1\" src=\" file://${basicInfo.imgPath}\" srcset=\"file://${basicInfo.imgPath} 1x, file://${basicInfo.imgPath} 2x\">\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t</svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<svg class=\"Path_1\" viewBox=\"315.195 -56.484 216.57 218.404\">\n" +
                "\t\t\t\t<path id=\"Path_1\" d=\"M 513.05078125 161.9197387695312 L 511.6031799316406 161.1067199707031 C 523.7064208984375 139.5662994384766 530.1052856445312 115.0393676757812 530.1052856445312 90.17788696289062 C 530.1052856445312 10.22353172302246 465.057373046875 -54.82446670532227 385.1029663085938 -54.82446670532227 C 360.9623107910156 -54.82446670532227 337.0628662109375 -48.77231216430664 315.9867858886719 -37.32390594482422 L 315.1950073242188 -38.78169250488281 C 336.5123596191406 -50.36289978027344 360.6865234375 -56.48400115966797 385.1029663085938 -56.48400115966797 C 465.9727783203125 -56.48400115966797 531.7647705078125 9.308107376098633 531.7647705078125 90.17788696289062 C 531.7647705078125 115.3232192993164 525.2929077148438 140.1319885253906 513.05078125 161.9197387695312 Z\">\n" +
                "\t\t\t\t</path>\n" +
                "\t\t\t</svg>\n" +
                "\t\t\t<svg class=\"Path_2\" viewBox=\"224.743 27.341 35.851 159.84\">\n" +
                "\t\t\t\t<path id=\"Path_2\" d=\"M 257.9578552246094 187.1807708740234 C 236.2289123535156 158.8015289306641 224.7429962158203 124.858772277832 224.7429962158203 89.02432250976562 C 224.7429962158203 67.66539001464844 228.8446807861328 46.91267013549805 236.9334869384766 27.34099769592285 L 240.0001068115234 28.60921096801758 C 232.0785827636719 47.77640151977539 228.0620574951172 68.10333251953125 228.0620574951172 89.02432250976562 C 228.0620574951172 124.1237945556641 239.311767578125 157.3680725097656 260.5936279296875 185.1633911132812 L 257.9578552246094 187.1807708740234 Z\">\n" +
                "\t\t\t\t</path>\n" +
                "\t\t\t</svg>\n" +
                "\t\t\t<svg class=\"Path_3\" viewBox=\"384.154 -94.241 144.527 79.213\">\n" +
                "\t\t\t\t<path id=\"Path_3\" d=\"M 516.583740234375 -15.0277042388916 C 484.2072448730469 -55.52544403076172 435.9389038085938 -78.75173187255859 384.1539916992188 -78.75173187255859 L 384.1539916992188 -94.24099731445312 C 440.6711730957031 -94.24099731445312 493.3503112792969 -68.8939208984375 528.680908203125 -24.70000076293945 L 516.583740234375 -15.0277042388916 Z\">\n" +
                "\t\t\t\t</path>\n" +
                "\t\t\t</svg>\n" +
                "\t\t</div>\n" +
                "\t\t<div id=\"Pic_t\">\n" +


                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t\n" +
                "\t<div id=\"Name\">\n" +
                "\t\t<div id=\"Muhammad_Ahmad_Raza\">\n" +
                "\t\t\t<span>${basicInfo.name}</span>\n" +
                "\t\t</div>\n" +
                "\t\t<div id=\"Manager_Producer\">\n" +
                "\t\t\t<span>${basicInfo.designation}</span>\n" +
                "\t\t</div>\n" +
                "\t\t<div id=\"P_058_302_59_35\">\n" +
                "\t\t\t<span>P</span><span style=\"font-style:normal;font-weight:bold;color:rgba(10,10,10,1);\"> ${basicInfo.phone}</span>\n" +
                "\t\t</div>\n" +
                "\t\t<div id=\"E__julesmailcom\">\n" +
                "\t\t\t<span>E </span><span style=\"font-style:normal;font-weight:bold;color:rgba(10,10,10,1);\"> ${basicInfo.gmail}</span>\n" +
                "\t\t</div>\n" +
                "\t\t<svg class=\"Rectangle_34\">\n" +
                "\t\t\t<rect id=\"Rectangle_34\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"369\" height=\"244\">\n" +
                "\t\t\t</rect>\n" +
                "\t\t</svg>\n" +
                "\t</div>\n" +
                "\t<div id=\"Right_Side\">\n" +
                "\t\t<div class=\"Ach\">\n" +
                "\t\t\t<div class=\"Group_41\">\n" +
                "\t\t\t\t<div class=\"Profile_dd\">\n" +
                "\t\t\t\t\t<span>Education</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"Group_42\">"
        for (i in educations){
            htmlCode=htmlCode+"<div class=\"Lorem_ipsum_dolor_sit_amet_con\">\n" +
                    "\t\t\t\t\t<h4>${i.school} ${i.city} (${i.startDate} - ${i.endDate})</h4>\n" +
                    "\t\t\t\t\t<h3>${i.degree}</h3>\n" +
                    "\t\t\t\t\t<span>${i.details}</span>\n" +
                    "\t\t\t\t</div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"Ach\">\n" +
                "\t\t\t<div class=\"Group_41\">\n" +
                "\t\t\t\t<div class=\"Profile_dd\">\n" +
                "\t\t\t\t\t<span>Skills</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"Group_42\">"
        for (i in skills){
            htmlCode=htmlCode+"<div class=\"Lorem_ipsum_dolor_sit_amet_con\">\n" +
                    "\t\t\t\t\t<span>${i.title} (${i.expLevel})</span>\n" +
                    "\t\t\t\t</div>"
        }
        htmlCode=htmlCode+"\t\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"Ach\">\n" +
                "\t\t\t<div class=\"Group_41\">\n" +
                "\t\t\t\t<div class=\"Profile_dd\">\n" +
                "\t\t\t\t\t<span>Languages</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"Group_42\">"
        for (i in languages){
            htmlCode=htmlCode+"<div class=\"Lorem_ipsum_dolor_sit_amet_con\">\n" +
                    "\t\t\t\t\t<span>${i.lang} (${i.expLevel})</span>\n" +
                    "\t\t\t\t</div>"
        }

        htmlCode=htmlCode+"\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"Ach\">\n" +
                "\t\t\t<div class=\"Group_41\">\n" +
                "\t\t\t\t<div class=\"Profile_dd\">\n" +
                "\t\t\t\t\t<span>Hobbies</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"Group_42\">"
        for (i in hobbies){
            htmlCode=htmlCode+"<div class=\"Lorem_ipsum_dolor_sit_amet_con\">\n" +
                    "\t\t\t\t\t<span>${i.title}</span>\n" +
                    "\t\t\t\t</div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"Ach\">\n" +
                "\t\t\t<div class=\"Group_41\">\n" +
                "\t\t\t\t<div class=\"Profile_dd\">\n" +
                "\t\t\t\t\t<span>Referances</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"Group_42\">"
        for (i in references){
            htmlCode=htmlCode+"<div class=\"Lorem_ipsum_dolor_sit_amet_con\">\n" +
                    "\t\t\t\t\t<h4>${i.companyName}</h4>\n" +
                    "\t\t\t\t\t<h3>${i.personName}</h3>\n" +
                    "\t\t\t\t\t<span>${i.phone}</span>\n" +
                    "\t\t\t\t\t<span>${i.gmail}</span>\n" +
                    "\t\t\t\t</div>"
        }
        htmlCode=htmlCode+"\t\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t</div>\n" +
                "\t<div id=\"Left_Side\">\n" +
                "\t\t<div class=\"Profile\">\n" +
                "\t\t\t<div class=\"Group_41\">\n" +
                "\t\t\t\t<div class=\"Profile_dd\">\n" +
                "\t\t\t\t\t<span>Profile</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"Group_42\">\n" +
                "\t\t\t\t<div class=\"Lorem_ipsum_dolor_sit_amet_con\">\n" +
                "\t\t\t\t\t<span>${objective.get(0).data}</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"EXPERIENCE\">\n" +
                "\t\t\t<div class=\"Group_49\">\n" +
                "\t\t\t\t<div class=\"Group_50\">\n" +
                "\t\t\t\t\t<div class=\"EXPERIENCE_d\">\n" +
                "\t\t\t\t\t\t<span>EXPERIENCE</span>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>"

        for (i in experiences){
            htmlCode=htmlCode+"<div class=\"Group_48\">\n" +
                    "\t\t\t\t<div class=\"Group_44\">\n" +
                    "\t\t\t\t\t<div class=\"Quentum_Comp\">\n" +
                    "\t\t\t\t\t\t<span>${i.company} (${i.city})</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t<div class=\"Supervisor\">\n" +
                    "\t\t\t\t\t\t<span>${i.title}</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t<div class=\"n_018_-_2020\">\n" +
                    "\t\t\t\t\t\t<span>${i.startDate} - ${i.EndDate}</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t<div class=\"Lorem_ipsum_dolor_sit_amet_con_dl\">\n" +
                    "\t\t\t\t\t\t<span>${i.details}</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t\n" +
                    "\t\t\t</div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t\t\n" +
                "\t\t</div>\n" +
                "\n" +
                "\t\t<div class=\"EXPERIENCE\">\n" +
                "\t\t\t<div class=\"Group_49\">\n" +
                "\t\t\t\t<div class=\"Group_50\">\n" +
                "\t\t\t\t\t<div class=\"EXPERIENCE_d\">\n" +
                "\t\t\t\t\t\t<span>Projects</span>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>"
        for (i in projects){
            htmlCode=htmlCode+"<div class=\"Group_48\">\n" +
                    "\t\t\t\t<div class=\"Group_44\">\n" +
                    "\t\t\t\t\t<div class=\"Supervisor2\">\n" +
                    "\t\t\t\t\t\t<span>${i.title}</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t<div class=\"Lorem_ipsum_dolor_sit_amet_con_dl\">\n" +
                    "\t\t\t\t\t\t<span>${i.details}</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t</div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t</div>\n" +
                "\t\t\n" +
                "\t\t<div class=\"Ach\">\n" +
                "\t\t\t<div class=\"Group_41\">\n" +
                "\t\t\t\t<div class=\"Profile_dd\">\n" +
                "\t\t\t\t\t<span>Achievements</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"Group_42\">"
        for (i in achivements){
            htmlCode=htmlCode+"<div class=\"Lorem_ipsum_dolor_sit_amet_con\">\n" +
                    "\t\t\t\t\t<h3>${i.title}</h3>\n" +
                    "\t\t\t\t\t<span>${i.details}</span>\n" +
                    "\t\t\t\t</div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +

                "\t\t\n" +
                "\t\t\n" +
                "\t</div>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>"

        return htmlCode
    }


    //This is template 3 design

    fun template3():String{
        var htmlCode:String="<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\"/>\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<title>Cv Templet – 3</title>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/temp2css.css\" media=\"all\" />\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"Cv_Templet__3\">\n" +
                "\t<svg class=\"Path_15_d\" viewBox=\"0 0 780.276 1551.987\">\n" +
                "\t\t<path id=\"Path_15_d\" d=\"M 0 0 L 772.7133178710938 0 L 780.275634765625 0 L 780.275634765625 1551.986694335938 L 0 1551.986694335938 L 0 0 Z\">\n" +
                "\t\t</path>\n" +
                "\t</svg>\n" +
                "\t<div id=\"Group_54\">\n" +
                "\t\t<svg class=\"Rectangle_54\">\n" +
                "\t\t\t<rect id=\"Rectangle_54\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"268.387\" height=\"1550.89\">\n" +
                "\t\t\t</rect>\n" +
                "\t\t</svg>\n" +
                "\t\t<svg class=\"Path_65\" viewBox=\"100.148 33.959 780.276 245.702\">\n" +
                "\t\t\t<path id=\"Path_65\" d=\"M 100.147705078125 33.95890045166016 L 880.42333984375 33.95890045166016 L 880.42333984375 279.6610107421875 L 100.147705078125 33.95890045166016 Z\">\n" +
                "\t\t\t</path>\n" +
                "\t\t</svg>\n" +
                "\t\t<svg class=\"Path_66\" viewBox=\"100.148 33.959 324.965 325.542\">\n" +
                "\t\t\t<path id=\"Path_66\" d=\"M 425.11279296875 136.2877349853516 L 100.147705078125 359.501220703125 L 100.147705078125 33.95890045166016 L 425.11279296875 136.2877349853516 Z\">\n" +
                "\t\t\t</path>\n" +
                "\t\t</svg>\n" +
                "\t</div>\n" +
                "\t<div id=\"Arslan_Ahmed\">\n" +
                "\t\t<span>${basicInfo.name}</span>\n" +
                "\t</div>\n" +
                "\t<svg class=\"Ellipse_5\">\n" +
                "\t\t<ellipse id=\"Ellipse_5\" rx=\"115\" ry=\"115\" cx=\"115\" cy=\"115\">\n" +
                "\t\t</ellipse>\n" +
                "\t</svg>\n" +
                "\t<div id=\"Senior_Interface_Designer\">\n" +
                "\t\t<span>${basicInfo.designation}</span>\n" +
                "\t</div>\n" +
                "\t<div id=\"Pic_eh\">\n" +
                "\t\t<img id=\"Group_1\" src=\"file://${basicInfo.imgPath}\" srcset=\"file://${basicInfo.imgPath} 1x, file://${basicInfo.imgPath} 2x\">\n" +
                "\t</div>\n" +
                "\t<div id=\"Right_side\">\n" +
                "\t\t\n" +
                "\t\t<div class=\"Profile_eq\">\n" +
                "\t\t\t\n" +
                "\t\t\t<div class=\"Group_41_es\">\n" +
                "\t\t\t\t<div class=\"Profile_et\">\n" +
                "\t\t\t\t\t<span>Profile</span>\n" +
                "\t\t\t\t</div>\n" +
                "                <svg class=\"Line_6\" viewBox=\"0 0 456.5 2\">\n" +
                "                    <path class=\"Line_61\" d=\"M 0 0 L 456.5 0\">\n" +
                "                    </path>\n" +
                "                </svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"Group_42_ev\">\n" +
                "\t\t\t\t<div class=\"Progressively_evolve_cross-pla\">\n" +
                "\t\t\t\t\t<span>${objective.get(0).data}</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "        <div class=\"Group_49\">\n" +
                "\t\t\t<div class=\"Group_50\">\n" +
                "\t\t\t\t<div class=\"EXPERIENCE_fe\">\n" +
                "\t\t\t\t\t<span>EXPERIENCE</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<svg class=\"Line_6\" viewBox=\"0 0 456.5 2\">\n" +
                "                    <path class=\"Line_61\" d=\"M 0 0 L 456.5 0\">\n" +
                "                    </path>\n" +
                "                </svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>"
        for (i in experiences){
            htmlCode=htmlCode+"<div class=\"Group_48\">\n" +
                    "\t\t\t<div class=\"Group_43\">\n" +
                    "\t\t\t\t<div class=\"Group_43_e\">\n" +
                    "\t\t\t\t\t<div class=\"Facebook_Islamabad\">\n" +
                    "\t\t\t\t\t\t<span>${i.company} (${i.city})</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t<div class=\"Senior_Interface_Designer_e\">\n" +
                    "\t\t\t\t\t\t<span>${i.title}r</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t<div class=\"n_018_-_2020_e\">\n" +
                    "\t\t\t\t\t\t<span>${i.startDate} - ${i.EndDate}</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "                    <div class=\"Intrinsicly_enable_optimal_cor\">\n" +
                    "\t\t\t\t\t\t<span>${i.details}</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t\n" +
                    "\t\t\t</div>\n" +
                    "\t\t</div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t<div class=\"Group_49\">\n" +
                "\t\t\t<div class=\"Group_50\">\n" +
                "\t\t\t\t<div class=\"EXPERIENCE_fe\">\n" +
                "\t\t\t\t\t<span>EDUCATION</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<svg class=\"Line_6\" viewBox=\"0 0 456.5 2\">\n" +
                "                    <path class=\"Line_61\" d=\"M 0 0 L 456.5 0\">\n" +
                "                    </path>\n" +
                "                </svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>"
        for (i in educations){
            htmlCode=htmlCode+"<div class=\"Group_48\">\n" +
                    "\t\t\t<div class=\"Group_43\">\n" +
                    "\t\t\t\t<div class=\"Group_43_e\">\n" +
                    "\t\t\t\t\t<div class=\"Facebook_Islamabad\">\n" +
                    "\t\t\t\t\t\t<span>${i.degree} (${i.city})</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t<div class=\"Senior_Interface_Designer_e\">\n" +
                    "\t\t\t\t\t\t<span>${i.school}</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t<div class=\"n_018_-_2020_e\">\n" +
                    "\t\t\t\t\t\t<span>${i.startDate} - ${i.endDate}</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "                    <div class=\"Intrinsicly_enable_optimal_cor\">\n" +
                    "\t\t\t\t\t\t<span>${i.details}</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t\n" +
                    "\t\t\t</div>\n" +
                    "\t\t</div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t<div class=\"Group_49\">\n" +
                "\t\t\t<div class=\"Group_50\">\n" +
                "\t\t\t\t<div class=\"EXPERIENCE_fe\">\n" +
                "\t\t\t\t\t<span>PROJECTS</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<svg class=\"Line_6\" viewBox=\"0 0 456.5 2\">\n" +
                "                    <path class=\"Line_61\" d=\"M 0 0 L 456.5 0\">\n" +
                "                    </path>\n" +
                "                </svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>"
        for (i in projects){
            htmlCode=htmlCode+"<div class=\"Group_48\">\n" +
                    "\t\t\t<div class=\"Group_43\">\n" +
                    "\t\t\t\t<div class=\"Group_43_e\">\n" +
                    "\t\t\t\t\t<div class=\"Facebook_Islamabad\">\n" +
                    "\t\t\t\t\t\t<span>${i.title}</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\n" +
                    "                    <div class=\"Intrinsicly_enable_optimal_cor\">\n" +
                    "\t\t\t\t\t\t<span>${i.details}</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t\n" +
                    "\t\t\t</div>\n" +
                    "\t\t</div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t<div class=\"Group_49\">\n" +
                "\t\t\t<div class=\"Group_50\">\n" +
                "\t\t\t\t<div class=\"EXPERIENCE_fe\">\n" +
                "\t\t\t\t\t<span>ACHIEVEMENTS</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<svg class=\"Line_6\" viewBox=\"0 0 456.5 2\">\n" +
                "                    <path class=\"Line_61\" d=\"M 0 0 L 456.5 0\">\n" +
                "                    </path>\n" +
                "                </svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>"
        for (i in achivements){
            htmlCode=htmlCode+"<div class=\"Group_48\">\n" +
                    "\t\t\t<div class=\"Group_43\">\n" +
                    "\t\t\t\t<div class=\"Group_43_e\">\n" +
                    "\t\t\t\t\t<div class=\"Facebook_Islamabad\">\n" +
                    "\t\t\t\t\t\t<span>${i.title}</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\n" +
                    "                    <div class=\"Intrinsicly_enable_optimal_cor\">\n" +
                    "\t\t\t\t\t\t<span>${i.details}</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t\n" +
                    "\t\t\t</div>\n" +
                    "\t\t</div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t\n" +
                "\t</div>\n" +
                "\t<div id=\"Group_113\">\n" +
                "\t\t\n" +
                "\t\t<div class=\"CONTACT_go\">\n" +
                "\t\t\t<div class=\"CONTACT_gp\">\n" +
                "\t\t\t\t<span>CONTACT</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<svg class=\"Line_1\" viewBox=\"0 0 233.5 2\">\n" +
                "\t\t\t<path class=\"Line_198\" d=\"M 0 0 L 233.5 0\">\n" +
                "\t\t\t</path>\n" +
                "\t\t</svg>\n" +
                "\t\t<div class=\"CONTACT\">\n" +
                "\t\t\t<div class=\"n_2-4586-846\">\n" +
                "\t\t\t\t<span>${basicInfo.phone}</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"gordonalbertsonemailcom\">\n" +
                "\t\t\t\t<span>${basicInfo.gmail}</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"n_4_Bowery_St_\">\n" +
                "\t\t\t\t<span>${basicInfo.dob}</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"wwwyourcompanycom\">\n" +
                "\t\t\t\t<span>${basicInfo.address}</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t\n" +
                "\t\t</div>\n" +
                "\n" +
                "\n" +
                "\t\t<div class=\"CONTACT_go\">\n" +
                "\t\t\t<div class=\"CONTACT_gp\">\n" +
                "\t\t\t\t<span>SKILLS</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<svg class=\"Line_1\" viewBox=\"0 0 233.5 2\">\n" +
                "\t\t\t<path class=\"Line_198\" d=\"M 0 0 L 233.5 0\">\n" +
                "\t\t\t</path>\n" +
                "\t\t</svg>\n" +
                "\t\t<div class=\"CONTACT\">"
        for (i in skills){
            htmlCode=htmlCode+"<div class=\"n_2-4586-846\">\n" +
                    "\t\t\t\t<span>${i.title} (${i.expLevel})</span>\n" +
                    "\t\t\t</div>"
        }

        htmlCode=htmlCode+"\t\n" +
                "\t\t</div>\n" +
                "\t\t\n" +
                "\n" +
                "\n" +
                "\t\t<div class=\"CONTACT_go\">\n" +
                "\t\t\t<div class=\"CONTACT_gp\">\n" +
                "\t\t\t\t<span>HOBBIES</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<svg class=\"Line_1\" viewBox=\"0 0 233.5 2\">\n" +
                "\t\t\t<path class=\"Line_198\" d=\"M 0 0 L 233.5 0\">\n" +
                "\t\t\t</path>\n" +
                "\t\t</svg>\n" +
                "\t\t<div class=\"CONTACT\">"
        for (i in hobbies){
            htmlCode=htmlCode+"<div class=\"n_2-4586-846\">\n" +
                    "\t\t\t\t<span>${i.title}</span>\n" +
                    "\t\t\t</div>"
        }
        htmlCode=htmlCode+"\t\n" +
                "\t\t\t\n" +
                "\t\t</div>\n" +
                "\n" +
                "\n" +
                "\t\t<div class=\"CONTACT_go\">\n" +
                "\t\t\t<div class=\"CONTACT_gp\">\n" +
                "\t\t\t\t<span>LANGUAGES</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<svg class=\"Line_1\" viewBox=\"0 0 233.5 2\">\n" +
                "\t\t\t<path class=\"Line_198\" d=\"M 0 0 L 233.5 0\">\n" +
                "\t\t\t</path>\n" +
                "\t\t</svg>\n" +
                "\t\t<div class=\"CONTACT\">"
        for (i in languages){
            htmlCode=htmlCode+"<div class=\"n_2-4586-846\">\n" +
                    "\t\t\t\t<span>${i.lang} (${i.expLevel})</span>\n" +
                    "\t\t\t</div>"
        }
        htmlCode=htmlCode+"\t\n" +
                "\t\t</div>\n" +
                "\n" +
                "\n" +
                "\t\t<div class=\"CONTACT_go\">\n" +
                "\t\t\t<div class=\"CONTACT_gp\">\n" +
                "\t\t\t\t<span>REFERENCES</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<svg class=\"Line_1\" viewBox=\"0 0 233.5 2\">\n" +
                "\t\t\t<path class=\"Line_198\" d=\"M 0 0 L 233.5 0\">\n" +
                "\t\t\t</path>\n" +
                "\t\t</svg>\n"
        for (i in references){
            htmlCode=htmlCode+"<div class=\"CONTACT\">\n" +
                    "\t\t\t<div class=\"n_2-4586-846\">\n" +
                    "\t\t\t\t<span>${i.companyName}</span>\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<div class=\"gordonalbertsonemailcom\">\n" +
                    "\t\t\t\t<span>${i.personName}</span>\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<div class=\"n_4_Bowery_St_\">\n" +
                    "\t\t\t\t<span>${i.phone}</span>\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<div class=\"wwwyourcompanycom\">\n" +
                    "\t\t\t\t<span>${i.gmail}</span>\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t\n" +
                    "\t\t</div>"
        }
        htmlCode=htmlCode+"\n" +
                "\n" +
                "\t</div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>"


        return htmlCode
    }


    //this is template 4


    fun template4():String{
        var htmlCode="<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\"/>\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<title>Cv Templet – 6</title>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/temp3css.css\" media=\"all\" />\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"Cv_Templet__6\">\n" +
                "\t<svg class=\"Rectangle_70\">\n" +
                "\t\t<rect id=\"Rectangle_70\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"257\" height=\"150\">\n" +
                "\t\t</rect>\n" +
                "\t</svg>\n" +
                "\t<svg class=\"Path_20\" viewBox=\"0 0 1 1\">\n" +
                "\t\t<path id=\"Path_20\" d=\"M 0 0 L 0 0 Z\">\n" +
                "\t\t</path>\n" +
                "\t</svg>\n" +
                "\t<svg class=\"Rectangle_69\">\n" +
                "\t\t<rect id=\"Rectangle_69\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"549\" height=\"114\">\n" +
                "\t\t</rect>\n" +
                "\t</svg>\n"

        if (basicInfo.imgPath!="empty"){
            htmlCode=htmlCode+"\t<svg class=\"Ellipse_6\">\n" +
                    "\t\t<ellipse id=\"Ellipse_6\" rx=\"109\" ry=\"109\" cx=\"109\" cy=\"109\">\n" +
                    "\t\t\t\t<img id=\"Group_1\" src=\" file://${basicInfo.imgPath}\" srcset=\"file://${basicInfo.imgPath} 1x, file://${basicInfo.imgPath} 2x\">\n" +
                    "\t\t</ellipse>\n" +
                    "\t</svg>\n"
        }

        htmlCode=htmlCode+"\t<div id=\"mUBASHAR_aHMAD\">\n" +
                "\t\t<span>${basicInfo.name}</span>\n" +
                "\t</div>\n" +
                "\t<div id=\"Graphic_Designer\">\n" +
                "\t\t<span>${basicInfo.designation}</span>\n" +
                "\t</div>\n" +
                "\t<div id=\"Left_side\">\n"

        if (objective.size>0){
            htmlCode=htmlCode+"<div class=\"Experience\">\n" +
                    "\t\t\t<div class=\"Group_116\">\n" +
                    "\t\t\t\t<div class=\"Group_66\">\n" +
                    "\t\t\t\t\t<div class=\"Group_50_bp\">\n" +
                    "\t\t\t\t\t\t<div class=\"EXPERIENCE\">\n" +
                    "\t\t\t\t\t\t\t<span>Objectives</span>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<svg class=\"Rectangle_83\">\n" +
                    "\t\t\t\t<rect class=\"Rectangle_831\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"803\" height=\"52\">\n" +
                    "\t\t\t\t</rect>\n" +
                    "\t\t\t</svg>\n" +
                    "\n" +
                    "\t\t\t<div class=\"Group_67\">\n" +
                    "\t\t\t\t<div class=\"Group_43\">\n" +
                    "\t\t\t\t\t<div class=\"Group_43_bd\">\n" +
                    "\t\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t<div class=\"Intrinsicly_enable_optimal_cor\">\n" +
                    "\t\t\t\t\t\t\t<span>${objective.get(0).data}</span>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t</div>\n" +
                    "\n" +
                    "\t\t\t\n" +
                    "\t\t\t\n" +
                    "\t\t</div>"
        }

        if(experiences.size>0){
            htmlCode=htmlCode+"\t\t<div class=\"Experience\">\n" +
                    "\t\t\t<div class=\"Group_116\">\n" +
                    "\t\t\t\t<div class=\"Group_66\">\n" +
                    "\t\t\t\t\t<div class=\"Group_50_bp\">\n" +
                    "\t\t\t\t\t\t<div class=\"EXPERIENCE\">\n" +
                    "\t\t\t\t\t\t\t<span>EXPERIENCE</span>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<svg class=\"Rectangle_83\">\n" +
                    "\t\t\t\t<rect class=\"Rectangle_831\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"803\" height=\"52\">\n" +
                    "\t\t\t\t</rect>\n" +
                    "\t\t\t</svg>\n" +
                    "\n"
            for (i in experiences){
                htmlCode=htmlCode+"<div class=\"Group_67\">\n" +
                        "\t\t\t\t<div class=\"Group_43\">\n" +
                        "\t\t\t\t\t<div class=\"Group_43_bd\">\n" +
                        "\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<div class=\"Facebook_Islamabad\">\n" +
                        "\t\t\t\t\t\t\t<span>${i.company} (${i.city})</span>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<div class=\"Senior_Interface_Designer\">\n" +
                        "\t\t\t\t\t\t\t<span>${i.title}</span>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<div class=\"n_018_-_2020\">\n" +
                        "\t\t\t\t\t\t\t<span>${i.startDate} - ${i.EndDate}</span>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<div class=\"Intrinsicly_enable_optimal_cor\">\n" +
                        "\t\t\t\t\t\t\t<span>${i.details}</span>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\n" +
                        "\t\t\t\t</div>\n" +
                        "\t\t\t</div>"
            }

            htmlCode=htmlCode+"\n" +
                    "\t\t</div>\n"
        }

        if(educations.size>0){
            htmlCode=htmlCode+"\n" +
                    "\t\t<div class=\"Experience\">\n" +
                    "\t\t\t<div class=\"Group_116\">\n" +
                    "\t\t\t\t<div class=\"Group_66\">\n" +
                    "\t\t\t\t\t<div class=\"Group_50_bp\">\n" +
                    "\t\t\t\t\t\t<div class=\"EXPERIENCE\">\n" +
                    "\t\t\t\t\t\t\t<span>Education</span>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<svg class=\"Rectangle_83\">\n" +
                    "\t\t\t\t<rect class=\"Rectangle_831\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"803\" height=\"52\">\n" +
                    "\t\t\t\t</rect>\n" +
                    "\t\t\t</svg>\n" +
                    "\n"
            for (i in educations){
                htmlCode=htmlCode+"<div class=\"Group_67\">\n" +
                        "\t\t\t\t<div class=\"Group_43\">\n" +
                        "\t\t\t\t\t<div class=\"Group_43_bd\">\n" +
                        "\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<div class=\"Facebook_Islamabad\">\n" +
                        "\t\t\t\t\t\t\t<span>${i.school} (${i.city})</span>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<div class=\"Senior_Interface_Designer\">\n" +
                        "\t\t\t\t\t\t\t<span>${i.degree}</span>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<div class=\"n_018_-_2020\">\n" +
                        "\t\t\t\t\t\t\t<span>${i.startDate} - ${i.endDate}</span>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<div class=\"Intrinsicly_enable_optimal_cor\">\n" +
                        "\t\t\t\t\t\t\t<span>${i.details}</span>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\n" +
                        "\t\t\t\t</div>\n" +
                        "\t\t\t</div>"
            }
            htmlCode=htmlCode+"\n" +
                    "\t\t</div>\n"
        }

        if (projects.size>0){
            htmlCode=htmlCode+"\t\t<div class=\"Experience\">\n" +
                    "\t\t\t<div class=\"Group_116\">\n" +
                    "\t\t\t\t<div class=\"Group_66\">\n" +
                    "\t\t\t\t\t<div class=\"Group_50_bp\">\n" +
                    "\t\t\t\t\t\t<div class=\"EXPERIENCE\">\n" +
                    "\t\t\t\t\t\t\t<span>Projects</span>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<svg class=\"Rectangle_83\">\n" +
                    "\t\t\t\t<rect class=\"Rectangle_831\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"803\" height=\"52\">\n" +
                    "\t\t\t\t</rect>\n" +
                    "\t\t\t</svg>\n"
            for (i in projects){
                htmlCode=htmlCode+"<div class=\"Group_67\">\n" +
                        "\t\t\t\t<div class=\"Group_43\">\n" +
                        "\t\t\t\t\t<div class=\"Group_43_bd\">\n" +
                        "\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<div class=\"Facebook_Islamabad\">\n" +
                        "\t\t\t\t\t\t\t<span>${i.title}</span>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<div class=\"Intrinsicly_enable_optimal_cor\">\n" +
                        "\t\t\t\t\t\t\t<span>${i.details}</span>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\n" +
                        "\t\t\t\t</div>\n" +
                        "\t\t\t</div>"
            }
            htmlCode=htmlCode+"\n" +
                    "\t\t</div>\n"

        }

        ////////////

        if (achivements.size>0){

            htmlCode=htmlCode+"\t\t<div class=\"Experience\">\n" +
                    "\t\t\t<div class=\"Group_116\">\n" +
                    "\t\t\t\t<div class=\"Group_66\">\n" +
                    "\t\t\t\t\t<div class=\"Group_50_bp\">\n" +
                    "\t\t\t\t\t\t<div class=\"EXPERIENCE\">\n" +
                    "\t\t\t\t\t\t\t<span>Achievements</span>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<svg class=\"Rectangle_83\">\n" +
                    "\t\t\t\t<rect class=\"Rectangle_831\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"803\" height=\"52\">\n" +
                    "\t\t\t\t</rect>\n" +
                    "\t\t\t</svg>"

            for (i in achivements){
                htmlCode=htmlCode+"<div class=\"Group_67\">\n" +
                        "\t\t\t\t<div class=\"Group_43\">\n" +
                        "\t\t\t\t\t<div class=\"Group_43_bd\">\n" +
                        "\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<div class=\"Facebook_Islamabad\">\n" +
                        "\t\t\t\t\t\t\t<span>${i.title}</span>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<div class=\"Intrinsicly_enable_optimal_cor\">\n" +
                        "\t\t\t\t\t\t\t<span>${i.details}</span>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\n" +
                        "\t\t\t\t</div>\n" +
                        "\t\t\t</div>"
            }

            htmlCode=htmlCode+"\n" +
                    "\t\t</div>\n"
        }


        htmlCode=htmlCode+"\t</div>\n" +
                "\t<div id=\"Right_Side\">\n" +


                "\t\t<div class=\"CONTACT\">\n" +
                "\t\t\t<div class=\"Group_123\">\n" +
                "\t\t\t\t<div class=\"CONTACT_c\">\n" +
                "\t\t\t\t\t<span>CONTACT</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<svg class=\"Rectangle_73\">\n" +
                "\t\t\t\t\t<rect class=\"Rectangle_731\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"172\" height=\"28\">\n" +
                "\t\t\t\t\t</rect>\n" +
                "\t\t\t\t</svg>\n" +
                "\t\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"Group_124\">\n" +
                "\t\t\t\t<div class=\"gordonalbertsonemailcom\">\n" +
                "\t\t\t\t\t<span>${basicInfo.gmail}</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<div class=\"n_4_Bowery_St_\">\n" +
                "\t\t\t\t\t<span>${basicInfo.phone}</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<div class=\"wwwyourcompanycom\">\n" +
                "\t\t\t\t\t<span>${basicInfo.dob}</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<div class=\"n_2-4586-846\">\n" +
                "\t\t\t\t\t<span>${basicInfo.address}</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t\t\n" +
                "\t\t</div>\n"

        if (skills.size>0){
            htmlCode=htmlCode+"\t\t<div class=\"CONTACT\">\n" +
                    "\t\t\t<div class=\"Group_123\">\n" +
                    "\t\t\t\t<div class=\"CONTACT_c\">\n" +
                    "\t\t\t\t\t<span>SKILLS</span>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t<svg class=\"Rectangle_73\">\n" +
                    "\t\t\t\t\t<rect class=\"Rectangle_731\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"172\" height=\"28\">\n" +
                    "\t\t\t\t\t</rect>\n" +
                    "\t\t\t\t</svg>\n" +
                    "\t\t\t\t\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<div class=\"Group_124\">"

            for (i in skills){
                htmlCode=htmlCode+"<div class=\"set\">\n" +
                        "\t\t\t\t\t<span>${i.title} (${i.expLevel})</span>\n" +
                        "\t\t\t\t</div>"
            }
            htmlCode=htmlCode+"\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t\n" +
                    "\t\t</div>\n"
        }

        if (hobbies.size>0){
            htmlCode=htmlCode+"\t\t<div class=\"CONTACT\">\n" +
                    "\t\t\t<div class=\"Group_123\">\n" +
                    "\t\t\t\t<div class=\"CONTACT_c\">\n" +
                    "\t\t\t\t\t<span>HOBBIES</span>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t<svg class=\"Rectangle_73\">\n" +
                    "\t\t\t\t\t<rect class=\"Rectangle_731\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"172\" height=\"28\">\n" +
                    "\t\t\t\t\t</rect>\n" +
                    "\t\t\t\t</svg>\n" +
                    "\t\t\t\t\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<div class=\"Group_124\">"

            for (i in hobbies){
                htmlCode=htmlCode+"<div class=\"set\">\n" +
                        "\t\t\t\t\t<span>${i.title}</span>\n" +
                        "\t\t\t\t</div>"
            }

            htmlCode=htmlCode+"\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t\n" +
                    "\t\t</div>\n"
        }

        if(languages.size>0){
            htmlCode=htmlCode+"\t\t<div class=\"CONTACT\">\n" +
                    "\t\t\t<div class=\"Group_123\">\n" +
                    "\t\t\t\t<div class=\"CONTACT_c\">\n" +
                    "\t\t\t\t\t<span>LANGUAGES</span>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t<svg class=\"Rectangle_73\">\n" +
                    "\t\t\t\t\t<rect class=\"Rectangle_731\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"172\" height=\"28\">\n" +
                    "\t\t\t\t\t</rect>\n" +
                    "\t\t\t\t</svg>\n" +
                    "\t\t\t\t\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<div class=\"Group_124\">"

            for (i in languages){
                htmlCode=htmlCode+"<div class=\"set\">\n" +
                        "\t\t\t\t\t<span>${i.lang} (${i.expLevel})</span>\n" +
                        "\t\t\t\t</div>"
            }
            htmlCode=htmlCode+"\t\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t\n" +
                    "\t\t</div>\n"
        }
        if (references.size>0){

            htmlCode=htmlCode+"\t\t<div class=\"CONTACT\">\n" +
                    "\t\t\t<div class=\"Group_123\">\n" +
                    "\t\t\t\t<div class=\"CONTACT_c\">\n" +
                    "\t\t\t\t\t<span>REFERANCES</span>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t<svg class=\"Rectangle_73\">\n" +
                    "\t\t\t\t\t<rect class=\"Rectangle_731\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"172\" height=\"28\">\n" +
                    "\t\t\t\t\t</rect>\n" +
                    "\t\t\t\t</svg>\n" +
                    "\t\t\t\t\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<div class=\"Group_124\">"
            for (i in references){
                htmlCode=htmlCode+"<div class=\"set\">\n" +
                        "\t\t\t\t\t<p>${i.companyName}</p>\n" +
                        "\t\t\t\t\t<p>${i.personName}</p>\n" +
                        "\t\t\t\t\t<p>${i.phone}</p>\n" +
                        "\t\t\t\t\t<p>${i.gmail}</p>\n" +
                        "\t\t\t\t</div>"
            }
            htmlCode=htmlCode+"\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t\n" +
                    "\t\t</div>\t\t\n"

        }

        htmlCode=htmlCode+"\t</div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>"

        return htmlCode
    }
}