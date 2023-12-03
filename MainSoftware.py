# Finder Pal Group
# CSC 485
# 10/30/2023
import ImageRecognition as ir
import sys
import os
import shutil

if (args_count := len(sys.argv)) > 2:
    print(f"One argument expected, got {args_count - 1}")
    raise SystemExit(2)
elif args_count < 2:
    print("You must include a target")
    raise SystemExit(2)

if(sys.argv[1] == "object1"):
    obj1 = os.path.join(os.getcwd(), "TargetImages\Object1.jpg")
    shutil.rmtree(os.path.join(os.getcwd(), "StoreImages" ))
    os.mkdir(os.path.join(os.getcwd(), "StoreImages" ))
    highScore = 0
    detections = ir.SaveObjects(1)
    for path, dirc, files in os.walk(os.path.join(os.getcwd(), "StoreImages" )):
        for name in files:
            if name.endswith("-1.jpg"):
                score = ir.image_compare(obj1, os.path.join(path, name))
                if score > highScore:
                    highScore = score
                    target = os.path.join(path, name)

elif(sys.argv[1] == "object2"):
    obj1 = os.path.join(os.getcwd(), "TargetImages\Object2.jpg")
    shutil.rmtree(os.path.join(os.getcwd(), "StoreImages" ))
    os.mkdir(os.path.join(os.getcwd(), "StoreImages" ))
    highScore = 0
    detections = ir.SaveObjects(1)
    for path, dirc, files in os.walk(os.path.join(os.getcwd(), "StoreImages" )):
        for name in files:
            if name.endswith("-1.jpg"):
                score = ir.image_compare(obj1, os.path.join(path, name))
                if score > highScore:
                    highScore = score
                    target = os.path.join(path, name)

elif(sys.argv[1] == "object3"):
    obj1 = os.path.join(os.getcwd(), "TargetImages\Object3.jpg")
    shutil.rmtree(os.path.join(os.getcwd(), "StoreImages" ))
    os.mkdir(os.path.join(os.getcwd(), "StoreImages" ))
    highScore = 0
    detections = ir.SaveObjects(1)
    for path, dirc, files in os.walk(os.path.join(os.getcwd(), "StoreImages" )):
        for name in files:
            if name.endswith("-1.jpg"):
                score = ir.image_compare(obj1, os.path.join(path, name))
                if score > highScore:
                    highScore = score
                    target = os.path.join(path, name)







print(target)

def main():
    {
        
    }


if __name__ == "__main__": main()