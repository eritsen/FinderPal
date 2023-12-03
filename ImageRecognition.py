'''
Project: Image Recognition
Creator: Evan Ritsen
Descripion:
'''
import cv2
import time
import image_comparer
import os
from imageai.Detection import ObjectDetection
from imageai.Detection import VideoObjectDetection


objDetect = ObjectDetection()
frameDetect = VideoObjectDetection()
camFeed = cv2.VideoCapture(0)

#Setting up the model
def SetUpModel():
    objDetect.setModelTypeAsYOLOv3()
    objDetect.setModelPath(os.path.join(os.getcwd(), "DataSets\yolov3.pt"))
    objDetect.loadModel()

#Saves Captured Objects
def SaveObjects(minutes):
    SetUpModel()
    timeEnd = time.monotonic() + (60 * minutes)
    num = 1
    while time.monotonic() < timeEnd:
        ret, img = camFeed.read()
        time.sleep(10)
        detections, img = objDetect.detectObjectsFromImage(input_image=img,
                             output_image_path= (os.path.join(os.getcwd(), "StoreImages\object"+str(num)+".jpg" )),
                             extract_detected_objects=True,
                             minimum_percentage_probability=70
                             )
        num += 1
    #for eachObject in detections:
    #    print(eachObject["name"], " : ", eachObject["percentage_probability"], " : ", eachObject["box_points"])
    return detections

#Compares and Scores Images Similarity 
def image_compare(img1, img2):
    image1 = cv2.imread(img1)
    image2 = cv2.imread(img2)
    return(image_comparer.calculate_score(image1, image2))

#Debugging Functions    
def SaveVideo():
    SetUpModel()
    detectedObj = frameDetect.detectObjectsFromVideo(camera_input=camFeed,
                  output_file_path= r"C:\Users\Desktop\Desktop\Capstone\Code\StoreImages\capturedOutput",
                  frames_per_second=15,
                  log_progress= True,
                  return_detected_frame = True,
                  detection_timeout= 10)
    
def CameraFeed():
    SetUpModel()
    camFeed.set(cv2.CAP_PROP_FRAME_WIDTH, 650)
    camFeed.set(cv2.CAP_PROP_FRAME_HEIGHT, 750)
    while True:
        ret, img = camFeed.read()
        modifiedImg, preds = objDetect.detectObjectsFromImage(input_image=img, 
                             output_type="array",
                             display_percentage_probability=True,
                             display_object_name=True)
        cv2.imshow("", modifiedImg)
        if(cv2.waitKey(1) & 0xFF == ord("q")) or (cv2.waitKey(1) == 27):
            break
    camFeed.release()
    cv2.destroyAllWindows();


def test():
    #image_compare()
    #CameraFeed()
    SaveObjects(1)
    #SaveVideo()



if __name__ == "__main__": test()